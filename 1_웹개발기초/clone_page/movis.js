document.addEventListener("DOMContentLoaded", function () {
  // 메인 콘텐츠, 버튼 클릭 시 내용 변경
  const slides = document.querySelectorAll(".main-text-wrap .slide");
  const dots = document.querySelectorAll(".controls .dot");
  const prevBtn = document.querySelector(".controls #prev");
  const nextBtn = document.querySelector(".controls #next");

  let currentSlide = 0;

  function showSlide(index) {
    slides.forEach((slide, i) => {
      slide.classList.toggle("active", i === index);
      slide.classList.toggle("slide-up", i === index);
    });

    dots.forEach((dot, i) => {
      dot.className = "fa-solid fa-circle dot";
    });
    dots[index].className = "fa-regular fa-circle-dot dot active";
  }

  prevBtn.addEventListener("click", () => {
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    showSlide(currentSlide);
  });

  nextBtn.addEventListener("click", () => {
    currentSlide = (currentSlide + 1 + slides.length) % slides.length;
    showSlide(currentSlide);
  });

  showSlide(currentSlide);

  // 뉴스 슬라이드
  const news = document.querySelectorAll(".news");
  const newsPrevBtn = document.querySelector(".news-controls #prev");
  const newsNextBtn = document.querySelector(".news-controls #next");

  let newsCurrentSlide = 0;

  function showNews(index) {
    news.forEach((n, i) => {
      n.classList.toggle("active", i === index);
    });
  }

  newsPrevBtn.addEventListener("click", () => {
    newsCurrentSlide = (newsCurrentSlide - 1 + news.length) % news.length;
    showNews(newsCurrentSlide);
  });

  newsNextBtn.addEventListener("click", () => {
    newsCurrentSlide = (newsCurrentSlide + 1 + news.length) % news.length;
    showNews(newsCurrentSlide);
  });

  showNews(newsCurrentSlide);
});
