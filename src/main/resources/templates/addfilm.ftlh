<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DirectorsApp</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

<div class="container mt-2">
    ${message!}
</div>
<div class="container mt-5">
    <form method="post">


        <div class="row">
            <div class="col">
                <input type="text" class="form-control" placeholder="Name" name="name">
            </div>
            <div class="col">
                <input type="date" class="form-control" placeholder="Release date" name="releaseDate">
            </div>

            <div class="col">
                <input type="text" class="form-control" placeholder="Genre" name="genre">
            </div>
            <div class="col">
                <input type="number" class="form-control" placeholder="ID of Director" name="directorId">
            </div>
            <#--            <input type="hidden" name="_csrf" value=${_csrf.token} />-->
            <div class="col">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </div>

    </form>
</div>
<div class="container mt-5">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">ID</th>

        </tr>
        </thead>
        <tbody>

        <#list directors as director>
            <tr>
                <td>${director.firstName} ${director.lastName} </td>
                <td>${director.id} </td>

            </tr>
        </#list>

        </tbody>
    </table>
</div>

</body>
</html>