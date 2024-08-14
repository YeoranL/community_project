//콜백함수(onLoad call back func)
function call_js(){
  //UI객체참조변수 선언
  let slideshow = document.querySelector(".slideshow");
  let slideshow_slides = document.querySelector(".slideshow_slides");
  //a에 들어있는 이미지배열
  let slides = document.querySelectorAll(".slideshow_slides a");
  let prev = document.querySelector(".prev");
  let next = document.querySelector(".next");
  let indicators = document.querySelectorAll(".indicator a");
  //회전목마 현재위치값, 시간설정, 슬라이드수
  let currentIndex = 0;
  let timer = null;
  let slideCount = slides.length;
  //회전목마 이미지를 우측으로 배치
  for(let i=0; i<slideCount; i++) {
    let newLeft = i*100+'%';
    slides[i].style.left = newLeft;
  }
  //회전목마를 움직인다.() slideshow_slides 왼쪽으로 -100% 이동
  function gotoSlide(index) {
    currentIndex = index;
    let newLeft = index*-100+'%';
    slideshow_slides.style.left = newLeft;
    indicators.forEach((e)=>{
      e.classList.remove("active");
    });
    // for(let i=0; i<indicators.length; i++) {
    //   indicators[i].classList.remove("active");
    // }
    indicators[currentIndex].classList.add("active");
  }
  //0번부터 3번까지 3초간 gotoSlide(index)호출
  gotoSlide(0);
  //3초간
  function startTimer() {
    timer = setInterval(()=>{
      currentIndex += 1;
      let index = currentIndex % 4;    
      gotoSlide(index);
    },3000);
  }
  startTimer();

  //이벤트처리
  slideshow_slides.addEventListener("mouseenter", function(){
    clearInterval(timer);
  });
  slideshow_slides.addEventListener("mouseleave", function(){
    startTimer();
  });
  prev.addEventListener("mouseenter", function(){
    clearInterval(timer);
  });
  next.addEventListener("mouseenter", function(){
    clearInterval(timer);
  });
  prev.addEventListener("click", function(e) {
    e.preventDefault(); // a tag 기본기능을 막는다
    currentIndex -= 1;
    if(currentIndex < 0) {
      currentIndex = slideCount - 1;
    }
    gotoSlide(currentIndex);
  });
  next.addEventListener("click", function(e) {
    e.preventDefault(); // a tag 기본기능을 막는다
    currentIndex += 1;
    if(currentIndex > slideCount - 1) {
      currentIndex = 0;
    }
    gotoSlide(currentIndex);
  });

  indicators.forEach((e)=>{
    e.addEventListener("mouseenter",()=>{
      clearInterval(timer);
    });
  });

  for(let i=0; i<indicators.length; i++) {
    e.preventDefault();
  }

}