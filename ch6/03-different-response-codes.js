app.get('/error', (req, res) => {
    res.status(500)
    res.render('error')
   })
   // or on one line...
   app.get('/error', (req, res) =>
   res.status(500).render('error'))