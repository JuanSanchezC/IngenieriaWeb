/**
 * 
 */
var appCliente = angular.module('clientes', ['ngRoute']);
appCliente.service('usuarios', function($http){
	
	this.autenticar = function(usuario, passwd){
		return $http({
			url: 'http://localhost:8080/JerseyClase/juan/usuario',
			method: 'GET',
			params:{
				login: usuario,
				pws:passwd
			}
		})
	}
});

appCliente.service('clientes', function($http){
	this.listaClientes = function(){
		return $http({
			url: 'http://localhost:8080/JerseyClase/juan/cliente',
			method: 'GET'
		})
	}
	
	this.guardar = function(cliente){
		return $http({
			url: 'http://localhost:8080/JerseyClase/juan/cliente',
			method: 'POST',
			params:{
				cedula: cliente.cedula,
				nombres: cliente.nombre,
				apellidos: cliente.apellidos,
				email: cliente.email,
				usuarioCrea: 'elver'
			}
		})
	}
});

appCliente.controller('listaClientes', function($scope, $location, clientes){
	clientes.listaClientes().then(
			function success(response){
				$scope.listaClientes = response.data.clienteJersey;
			}
	);
	
	$scope.agregar = function() {
		$location.url('/nuevo');
	}
});

appCliente.controller('login', function($scope, $location, usuarios){
	$scope.nombreUsuario = '';
	$scope.passwd = '';
	$scope.login = function() {
		usuarios.autenticar($scope.nombreUsuario, $scope.passwd).then(
			function success(data) {
				$location.url('/listaClientes');
			},			
			function failure(data) {
				alert(data.data);
			}
		);
	}
});

appCliente.controller('cliente', function($scope, $location, clientes) {
	$scope.cliente = {
		nombre: '',
		apellidos: '',
		cedula: '',
		email: ''
	};
	
	$scope.guardar = function() {
		clientes.guardar($scope.cliente).then(
			function success(data) {
				alert('Cliente creado');
				$location.url('/listaClientes');
			}
		)
	};
});

appCliente.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: 'login.html',
		controller: 'login'
	});
	
	$routeProvider.when('/listaClientes', {
		templateUrl: 'listaCliente.html',
		controller: 'listaClientes'
	});
	
	$routeProvider.when('/nuevo', {
		templateUrl: 'cliente.html',
		controller: 'cliente'
	});
}]);