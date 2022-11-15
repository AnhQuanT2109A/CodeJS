const express = require('express')
const expressHandlebars = require('express-handlebars').engine
const app = express()

app.engine('handlebars', expressHandlebars({defaultLayout: 'main'}))
app.set('view engine', 'handlebars')

// the layout file views/layouts/custom.handlebars will be used
app.get('/custom-layout', (req, res) =>
    res.render('custom-layout', { layout: 'custom' })
)

app.get('*', (req, res) => res.send('Check out our <a href="/custom-layout">custom layout</a> page!'))

const port = process.env.POST || 3000
app.listen(port, () => console.log (`\nnavigate to http://localhost:${port}/custom-layout\n`))