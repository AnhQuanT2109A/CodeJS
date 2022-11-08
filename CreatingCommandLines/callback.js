var wakeup = function(callback) {
    console.log("I'm waking up!");
    if(callback)
        if(typeof callback === 'function')
            callback();
};
var checkPhone = function(callback) {
    console.log("Checking phone...");
    if(callback)
        if(typeof callback === 'function')
            callback();
};
var eatBreakfast = function(callback) {
    console.log("I'm eating breafast...");
    if(callback)
        if(typeof callback === 'function')
            callback();
};

// wakeup();
// checkPhone();
// eatBreakfast();

wakeup(function() {
    checkPhone(function() {
        eatBreakfast();
    });
});