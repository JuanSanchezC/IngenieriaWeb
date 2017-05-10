/**
 * 
 */
var module = angular.module('myModule',[]);
module.controller('myController',['$scope', 
	function($scope){
	$scope.lista = [{texto:'Prueba 1', checked:true},{texto:'Prueba 2', checked:false}];
	$scope.agregar = function(){
		if($scope.texto.trim() == ''){
			alert("Debe digitar el texto");
			return;
		}
		console.log($scope.texto);
		$scope.lista.push({texto:$scope.texto, checked:false});
		$scope.texto = '';
	}
	$scope.eliminar = function(){		
		angular.forEach($scope.lista, function(item){			
			if(item.checked){
				var index = $scope.lista.indexOf(item);
				$scope.lista.splice(index, 1);
			}
		});
	}
}]);