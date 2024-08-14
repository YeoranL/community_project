package mngr.enc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbcon.DBUtil;
import work.crypt.BCrypt;
import work.crypt.SHA256;

public class PassCrypt {
	private static PassCrypt instance = new PassCrypt();

	public static PassCrypt getInstance() {
		if(instance == null) {
			instance = new PassCrypt();
		}
		return instance;
	}

	private PassCrypt() {
	}

	public void cryptProcess() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //1.SHA-256 를 사용하는 SHA256 클래스의 객체를 얻어낸다.
        SHA256 sha = SHA256.getInsatnce();

        try {
            conn = DBUtil.getConnection();

            pstmt = conn.prepareStatement("select user_id, user_password from tb_user where user_id = 'admin'");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("user_id");
                String orgPass = rs.getString("user_password");
                //2.패스워드를 암호화처리를 진행한다.
                String shaPass = sha.getSha256(orgPass.getBytes());
                String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
                
                System.out.println("*********** " + id);

                pstmt = conn.prepareStatement("update tb_user set user_password='1234' where user_id=?");
                //pstmt.setString(1, bcPass);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.dbReleaseClose(rs, pstmt, conn);
        }
    }
}
