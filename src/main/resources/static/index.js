angular.module('store', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/store';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                alert('Удален продукт с ID:'+productId);
                $scope.loadProducts();

            });
//        $http({
//            url: contextPath + '/products',
//            method: 'DELETE',
//            params: {
//                productId
//            }
//        }).then(function (response){
//             $scope.loadProducts();
//        });
    }

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/products',
            method: 'PUT',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();

        });
    }

    // $scope.addProduct = function (productId,name,cost,description){
    //     $http({
    //         url: contextPath + '/products',
    //         method: 'POST',
    //         params: {
    //             productId: productId,
    //             name: name,
    //             cost:cost,
    //             description: description
    //         }
    //     }).then(function (response) {
    //         $scope.loadProducts();
    //
    //     });
    //
    // }

    $scope.loadProducts();
});