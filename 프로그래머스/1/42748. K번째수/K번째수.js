function solution(array, commands) {
    var answer = [];
    
    for(var i = 0; i < commands.length; i++){
        var subArray = array.slice(commands[i][0]-1, commands[i][1]);
        subArray.sort(function(a,b){return a-b;});
        answer.push(subArray[commands[i][2]-1]);
    }

    return answer;
}