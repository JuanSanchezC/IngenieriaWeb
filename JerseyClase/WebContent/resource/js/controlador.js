/**
 * 
 */
var module = angular.module('myModule',[]);
module.controller('myController',['$scope', 
	function($scope){
	$scope.lista = [{texto:'Prueba 1', checked:true},{texto:'Prueba 2', checked:false}];
	$scope.texto = '';
	$scope.agregar = function(){
		if($scope.texto == ''){
			alert("Debe digitar el texto");
			return;
		}
		console.log($scope.texto);
		$scope.lista.push({texto:$scope.texto, checked:false});
		$scope.texto = '';
	}
	$scope.eliminar = function(){
		var lista = $scope.lista;
		$scope.lista = [];
		angular.forEach(lista, function(item){
			if(!item.checked){
				$scope.lista.push(item);
			}
		});
	}
}]);