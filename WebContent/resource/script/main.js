require.config({
	baseUrl: "/resource/script/aa",
	paths : {
		"jquery" : "../lib/jquery/jquery-1.11.2",
		"common" : "../lib/jquery/common"
	},
	shim : {
		'common' : {
			deps : [ 'jquery']
		}
	}
});