// 메인 콘텐츠, 버튼 클릭 시 내용 변경
document.addEventListener("DOMContentLoaded", function () {
  const slides = document.querySelectorAll(".main-text-wrap .slide");
  const prevBtn = document.querySelector(".controls #prev");
  const nextBtn = document.querySelector(".controls #next");

  let currentSlide = 0;

  function showSlide(index) {
    slides.forEach((slide, i) => {
      slide.classList.toggle("active", i === index);
    });
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
});
