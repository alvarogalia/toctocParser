length=377
for i in $( seq 377 $length )
do
	curl "https://www.toctoc.com/api/lista/propiedades?dormitoriodesde=1&dormitoriohasta=5&banosdesde=1&banoshasta=5&superficeDesde=&superficiehasta=&moneda=2&preciodesde=&preciohasta=&ordenarpor=antiguas&cargarmas=5000&tipoOperacion=0&tipoOperacionFamilia=3&tipoPropiedad=2&comuna=&region=" -H "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0" -H "Accept: */*" -H "Accept-Language: es-CL,es;q=0.8,en-US;q=0.5,en;q=0.3" --compressed -H "Referer: https://www.toctoc.com/Arriendo/departamento/metropolitana/santiago?dormitoriodesde=1&dormitoriohasta=5&banosdesde=1&banoshasta=5&superficeDesde=&superficiehasta=&moneda=2&preciodesde=&preciohasta=&ordenarpor=antiguas&cargarmas=5000&tipoOperacion=0" -H "x-access-token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjE4Ni45LjQuNjAiLCJpYXQiOjE1NDY0NTY4OTgsImV4cCI6MTU0NzA2MTY5OH0.tdpO46dLqXy00nQ1FmV6RgVyYH7gHw7Eul_t_JvuRfs" -H "origin: https://www.toctoc.com" -H "Connection: keep-alive" -H "Cookie: _ga=GA1.2.1323110744.1544624574; optimizelyEndUserId=oeu1544624944667r0.3818049908970317; optimizelySegments="%"7B"%"222204271535"%"22"%"3A"%"22ff"%"22"%"2C"%"222215970531"%"22"%"3A"%"22false"%"22"%"2C"%"222232940041"%"22"%"3A"%"22direct"%"22"%"7D; optimizelyBuckets="%"7B"%"7D; X-DATA=7313ae53-bc0f-4d23-aadf-1f7afb91df91; X-DATA-NPSW={""CantidadVisitas"":1,""FechaCreacion"":""2019-01-02T16:06:46.3280839-03:00"",""FechaUltimoIngreso"":""2019-01-02T16:16:26.484326-03:00"",""Detalles"":[{""TipoVistaNPS"":1,""Cantidad"":1,""FechaUltimoIngreso"":""2019-01-02T16:06:46.3280839-03:00""},{""TipoVistaNPS"":2,""Cantidad"":1,""FechaUltimoIngreso"":""2019-01-02T16:07:24.2436031-03:00""},{""TipoVistaNPS"":3,""Cantidad"":4,""FechaUltimoIngreso"":""2019-01-02T16:16:26.484326-03:00""}]}; NPS_93546e30_last_seen=1546456029945; NPS_93546e30_throttle=1546459631279; _gid=GA1.2.1801397619.1546456042; _fbp=fb.1.1546456044163.276844878; __RequestVerificationToken=pwNP3eaf0qlYOUSAFr1i2LL5yQYQ_sUpURh14Tau3e5zrrFL1c3LNXp0fJhXDsOT556mSzmVMHF1m6WPYJeNEqp0LPzP9T6GstiTXyif5lc1; __insp_wid=2107690165; __insp_slim=1546456586397; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudG9jdG9jLmNvbS9zZWFyY2gvaW5kZXgvP3BhcmFtPXtFc01vYmlsZTowfXtEZWZhdWx0OnRydWV9e2VzdGFkbzpVc2FkYX17Y29tdW5hOlNhbnRpYWdvJTIwZGUlMjBDaGlsZX17Y2FsbGU6U2FudGlhZ28lMjBkZSUyMENoaWxlfXtzdXBlcmZpY2llRkQ6bnVsbH17cHJlY2lvRkg6bnVsbH17bW9uZWRhOm51bGx9e2Rvcm1pdG9yaW9zRkQ6bnVsbH17ZG9ybWl0b3Jpb3NGSDpudWxsfXtiYW5vc0ZEOm51bGx9e2Jhbm9zRkg6bnVsbH17bGF0aXR1ZDotMzMuNDV9e2xvbmdpdHVkOi03MC42NjY2N317dmlld3BvcnQ6LTcwLjY3MDQ3ODgxMDcwNjM2LC0zMy40NTM4MDg4MTA3MDYzNiwtNzAuNjYyODYxMTg5MjkzNjQsLTMzLjQ0NjE5MTE4OTI5MzY0fXtFc0J1c3F1ZWRhVGV4dG86dHJ1ZX17dHY6bH17ZWNuOmZhbHNlfXtlYTp0cnVlfXtlY3U6ZmFsc2V9e0VzQnVzcXVlZGFWYWxpZGE6dHJ1ZX17dHA6MH17dGV4dG9CdXNxdWVkYTpzYW50aWFnb30"%"3D; __insp_targlpt=QnVzY2FyIHkgY29tcHJhciBjYXNhIHBvciBtYXBhIGVuIFRvYyBUb2M"%"3D; __insp_norec_sess=true; mp_29ae90688062e4e2e6d80b475cef8685_mixpanel="%"7B"%"22distinct_id"%"22"%"3A"%"20"%"22167a2d24dd8190-0514def79cca76-4c312979-100200-167a2d24dd9145"%"22"%"2C"%"22"%"24device_id"%"22"%"3A"%"20"%"22167a2d24dd8190-0514def79cca76-4c312979-100200-167a2d24dd9145"%"22"%"2C"%"22"%"24initial_referrer"%"22"%"3A"%"20"%"22"%"24direct"%"22"%"2C"%"22"%"24initial_referring_domain"%"22"%"3A"%"20"%"22"%"24direct"%"22"%"7D" -H "TE: Trailers" > salida_arriendo_departamentos.json
	echo "Listo! ${i}"
done