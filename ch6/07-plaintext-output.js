const express = require('express')
const expressHandlebars = require('express-handlebars').engine
const app = express()

app.engine('handlebars', expressHandlebars({defaultLayout: 'main'}))
app.set('view engine', 'handlebars')

app.get('/text', (req, res) => {
    res.type('text/plain')
    res.send('this is a test')
})

app.get('*', (req, res) => res.send('Check out our <a href="/text">plain text</a> page!'))

const port = process.env.POST || 3000
app.listen(port, () => console.log (`\nnavigate to http://localhost:${port}/text\n`))