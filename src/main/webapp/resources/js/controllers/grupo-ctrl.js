
angularApp.controller('GrupoCtrl', ['$scope', function($scope) {
	$scope.grupos = [ 
		{
			nome: 'Máfia do Sávio',
			descricao: 'Grupo da Máfia do Sávio'
		}, 
		{
			nome: 'Galera CWI',
			descricao: 'Grupo da gurizada da CWI'
		} 
	];
}]);