angularApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'resources/views/home.html',
		controller: 'HomeCtrl'
	});
}]);

angularApp.controller('HomeCtrl', function($scope, $sce, PostResource) {
	
	PostResource.list({blogId: 2}, function (response) {
		console.log(response);
		$scope.posts = response;	
	});
	
	$scope.trustHtml = function(htmlContent) {
		return $sce.trustAsHtml(htmlContent);
	};
	
});