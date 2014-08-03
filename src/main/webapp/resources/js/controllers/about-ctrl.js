angularApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/about', {
		templateUrl: 'resources/views/about.html',
		controller: 'AboutCtrl'
	});
}]);

angularApp.controller('AboutCtrl', function($scope) {
	$scope.introduction = "About Me";
});