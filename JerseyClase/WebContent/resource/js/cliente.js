/**
 * 
 */
var appCliente = angular.module('clientes', ['ngRoute']);
appCliente.service('clientes', function($http){
	this.listaClientes = function(){
		return $http({
			url: 'http://localhost:8080/JerseyClase/juan/cliente',
			method: 'GET'
		})
	}
});

appCliente.controller('listaClientes', function($scope, clientes){
	clientes.listaClientes().then(
			function success(response){
				$scope.listaClientes = response.data.clienteJersey;
			}
	);
});

appCliente.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: 'listaCliente.html',
		controller: 'listaClientes'
	});
}]);