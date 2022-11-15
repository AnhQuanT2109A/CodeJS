const express = require('express')
const expressHandlebars = require('express-handlebars').engine
const cookieParser = require('cookie-parser')
const session = require('express-session')
const catNames = require('cat-names')
const app = express()



//the following is needed
app.engine('handlebars', expressHandlebars({ defaultLayout: 'main' }))
app.set('view engine', 'handlebars')

// the following is needed for cookies suppport
app.use(cookieParser())

//the following is needed for session support 
app.use(session({ resave: false, saveUnitialized: false, secret: 'keyboard cat' }))

app.get('/greeting', (req, res) => {
    res.render('greeting', {
        message: 'Hello esteemed programmer!',
        style: req.query.style,
        userid: req.cookies.userid,
        username: req.session.username
    })
})
app.get('/set-random-userid', (req, res) => {
    res.cookie('userid', (Math.random() * 1000).toFixed(0))
    res.redirect('/greeting')
})


app.get('/set-random-username', (req, res) => {
    req.session.username = catNames.random()
    res.redirect('/greeting')
})

app.get('*', (req, res) => res.send('check out our "<a href=/about">About</a>" page!'))

const port = process.env.PORT || 3000
app.listen(port, () => console.log(`\nnavigate to http:\\localhost:${ port }/greeting\n`))