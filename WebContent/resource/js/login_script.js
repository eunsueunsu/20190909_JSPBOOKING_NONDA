$("#googlelogin").on("click", function(){
	$(".abcRioButtonContents").trigger("click");
});

function onLoad() {
	gapi.load('auth2,signin2', function() {
		var auth2 = gapi.auth2.init();
		
		auth2.then(function() {
			var isSignedIn = auth2.isSignedIn.get();
			var currentUser = auth2.currentUser.get();
			
			gapi.signin2.render('googleSigninButton', {
				'onsuccess' : 'onSignIn',
				'longtitle' : true,
				'theme' : 'dark',
				'width' : '0'
			});
		});
	});
}

function onSignIn(googleUser) {
	var profile = googleUser.getBasicProfile();
	var mId = profile.getEmail();
	var mName = profile.getName();
	
	$.ajax({
		url: "/Nonda/GoogleJoinServlet",
		type: "post",
		data: {
			mId: mId,
			mName: mName
		}
	});
}