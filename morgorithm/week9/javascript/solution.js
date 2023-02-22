const solution = (t, p) =>
  new Array(t.length - p.length + 1).fill(0).reduce((acc, _, i) => {
    if (+p >= +t.substring(i, i + p.length)) {
      acc++;
    }
    return acc;
  }, 0);

console.log(solution("3141592", "271") == 2);
console.log(solution("500220839878", "7") == 8);
console.log(solution("10203", "15") == 3);
