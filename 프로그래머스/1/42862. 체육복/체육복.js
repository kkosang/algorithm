function solution(n, lost, reserve) {
    var answer = 0;

    lostFilter = lost.filter(l => !reserve.includes(l));
    reserveFilter = reserve.filter(r => !lost.includes(r));

    lostFilter.sort((a, b) => a - b);
    reserveFilter.sort((a, b) => a - b);

    let i = 0; 
    let j = 0; 

    while (i < lostFilter.length && j < reserveFilter.length) {
        if (Math.abs(lostFilter[i] - reserveFilter[j]) <= 1) {
            answer++;
            i++;
            j++;
        } else if (lostFilter[i] < reserveFilter[j]) {
            i++;
        } else {
            j++;
        }
    }

    return n - lostFilter.length + answer;
}
