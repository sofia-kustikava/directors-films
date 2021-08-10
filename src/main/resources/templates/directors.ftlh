<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DirectorsApp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

<div class="container mt-5">
    <form method="get" action="/">

        <div class="row">
            <div class="col">
                <small class="form-text text-muted">last name</small>
                <#if lastName=="">
                    <input type="text" class="form-control" name="lastName">
                <#else>
                    <input type="text" value=${lastName} class="form-control" name="lastName">
                </#if>
            </div>
            <div class="col">
                <small class="form-text text-muted">Released from</small>
                <input type="date" value=${dateAfter} class="form-control" name="afterDate">
            </div>

            <div class="col" >
                <small class="form-text text-muted">Released until</small>
                <input type="date" value=${dateBefore} class="form-control" name="beforeDate">
            </div>
            <div class="col mt-4">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>

    </form>
</div>
<div class="container mt-5">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">Birth Date</th>
            <th scope="col">Film Name</th>
            <th scope="col">Release date</th>
            <th scope="col">Genre</th>
        </tr>
        </thead>
        <tbody>
        <#list films as film>
            <tr>
                <td>${film.director.firstName}</td>
                <td>${film.director.lastName}</td>
                <td>${film.director.birthDate}</td>
                <td>${film.name}</td>
                <td>${film.releaseDate}</td>
                <td>${film.genre}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>