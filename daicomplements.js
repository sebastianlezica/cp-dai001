var DaiComplements = (function(){

    DaiComplements = {
        open: function(successFn, errorFn){
            cordova.exec(successFn, errorFn, 'DaiComplements', 'open', []);
        }
    };
    return DaiComplements;
});
module.exports = new DaiComplements();
