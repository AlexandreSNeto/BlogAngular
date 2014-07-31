var angularApp = angular.module('AngularApp', ['ngRoute', 'ngResource']);

angularApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/grupos', {
		templateUrl: 'grupos.html',
		controller: 'GrupoCtrl'
	});
}]);
