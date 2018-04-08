var daicomplements = (function(){

    DaiComplements = {
        settings_datetime_open: function(successFn, errorFn){
            cordova.exec(successFn, errorFn, "DaiComplements", "settings_datetime_open", []);
        },
        battery_ignore_optimizations: function(successFn, errorFn){
            cordova.exec(successFn, errorFn, "DaiComplements", "battery_ignore_optimizations", []);
        }
    };
    return DaiComplements;
});
module.exports = new daicomplements();
