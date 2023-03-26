<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebLab1</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css"/>
</head>
<body>
<div class="container">
    <div class="header-item" id="header-item">Arzmonstr's lair</div>
    <div class="graph-item">
        <canvas id="canvas" width="500" height="500"></canvas>
    </div>
    <div class="form-item" id="form-item">
        <form action="" method="post" id="form" onsubmit="return false">
            <fieldset>
                <legend class="form_name">Select (x, y) and R</legend>
                <div class="form-field">
                    <span>Choose X:</span>
                    <input type="checkbox" class="custom-checkbox" id="x1" name="x_value" value="-2"><label
                        for="x1">-2</label>
                    <input type="checkbox" class="custom-checkbox" id="x2" name="x_value" value="-1.5"><label
                        for="x2">-1.5</label>
                    <input type="checkbox" class="custom-checkbox" id="x3" name="x_value" value="-1"><label
                        for="x3">-1</label><br>
                    <input type="checkbox" class="custom-checkbox" id="x4" name="x_value" value="-0.5"><label
                        for="x4">-0.5</label>
                    <input type="checkbox" class="custom-checkbox" id="x5" name="x_value" value="0"><label
                        for="x5">0</label>
                    <input type="checkbox" class="custom-checkbox" id="x6" name="x_value" value="0.5"><label
                        for="x6">0.5</label>
                    <input type="checkbox" class="custom-checkbox" id="x7" name="x_value" value="1"><label
                        for="x7">1</label>
                    <input type="checkbox" class="custom-checkbox" id="x8" name="x_value" value="1.5"><label
                        for="x8">1.5</label>
                    <input type="checkbox" class="custom-checkbox" id="x9" name="x_value" value="2"><label
                        for="x9">2</label><br>
                    <small>Error message</small>
                </div>
                <div class="form-field">
                    <span>Enter Y:</span>
                    <label for="y_value"></label><input type="text" name="y_value" id="y_value"
                                                        placeholder="(-3..5)"><br>
                    <small>Error message</small>
                </div>
                <div class="form-field">
                    <span>Enter R:</span>
                    <label for="r_value"></label><input type="text" name="r_value" id="r_value"
                                                        placeholder="(1..4)"><br>
                    <small>Error message</small>
                </div>
                <div>
                    <input type="submit" id="submit" value="Submit">
                    <input type="submit" id="clear" value="Clear table">
                </div>
            </fieldset>
        </form>
    </div>
    <div class="table-item" id="table-item">
        <table id="result_table">
            <thead>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Hit</th>
            <th>Local time</th>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="footer-item">
        <p>Author: Giniyatullin Arslan</p>
        <p>Group: P32121</p>
        <p>© 1993-2022 ITMO University</p>
    </div>
</div>
</body>

</html>