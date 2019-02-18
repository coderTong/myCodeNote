(function(exports){
	
	exports.rootVc = function() {
		return UIApp.keyWindow.rootViewController;
	};

	keyWin = function(){

		return UIApp.keyWindow;
	};

	exports.appId = [NSBundle mainBundle].bundleIdentifier;
	exports.appDisName = [[NSBundle mainBundle] infoDictionary]["CFBundleDisplayName"];

})(exports);