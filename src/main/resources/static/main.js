var app = angular.module("ToyManagement", []);
 
// Controller Part
app.controller("ToyController", function($scope, $http) {
 
 
    $scope.toys = [];
    $scope.toyForm = {
        toyID: 4,
        toyName: "",
        toySize: "",
        toyDescription: ""
    };
 
    _refreshToyData();
 
    $scope.submitToy = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.toyForm.toyID == -1) {
            method = "POST";
            url = '/toy';
        } else {
            method = "PUT";
            url = '/toy';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.toyForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createToy = function() {
        _clearFormData();
    }
 
    $scope.deleteToy = function(toy) {
        $http({
            method: 'DELETE',
            url: '/toy/' + toy.toyID
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editToy = function(toy) {
        $scope.toyForm.toyID = toy.toyID;
        $scope.toyForm.toyName = toy.toyName;
        $scope.toyForm.toySize = toy.toySize;
        $scope.toyForm.toyDescription = toy.toyDescription;
    };
 

    function _refreshToyData() {
        $http({
            method: 'GET',
            url: '/toys'
        }).then(
            function(res) { // success
                $scope.toys = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshToyData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.toyForm.toyID = -1;
        $scope.toyForm.toyName = "";
        $scope.toyForm.toySize = "";
        $scope.toyForm.toyDescription = ""
    };
});