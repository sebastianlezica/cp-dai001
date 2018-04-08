var CPDAI001 = (function(){

    DateSetting = {
        open: function(successFn, errorFn){
            cordova.exec(successFn,errorFn,'DateSetting','open',[]);
        }
    };
    return DateSetting;
});
module.exports = new CPDAI001();
