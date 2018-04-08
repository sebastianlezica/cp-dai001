var DaiComplements = (function(){

    DaiComplements = {
        settings_datetime_open: function(successFn, errorFn){
            cordova.exec(successFn, errorFn, "DaiComplements", "settings_datetime_open", []);
        },
        doze_request: function(successFn, errorFn){
            cordova.exec(successFn, errorFn, "DaiComplements", "doze_request", []);
        }
    };
    return DaiComplements;
});
module.exports = new DaiComplements();
