const express  = require('express');

// Constants
const PORT = process.env.PORT || 8080;
const HOST = '0.0.0.0';

// App
const app = express();
app.get('/', async (req, res) => {
    let now = new Date();
    res.send('<html><body onload="location.reload()"><h1 style="font-family:Courier;">'
        + now.getTime()
        + '</h1></body></html>');
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
