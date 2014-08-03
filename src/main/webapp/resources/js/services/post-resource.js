var postResource = angular.module('postResource', ['ngResource']);

postResource.factory('PostResource', function($resource) {
	return $resource('api/posts/list/', {}, {
		list: {
			method: 'GET',
			url: 'api/posts/list/:blogId',
			params: {blogId: '@blogId'},
			isArray: true
		},
		save: {
			method: 'POST',
			url: 'api/posts/add'
		}
	});
});
