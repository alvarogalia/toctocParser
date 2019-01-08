import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class CompraCasasUsadas extends Thread{
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("sh\\salida_compra_casas_usadas.json"))) {
            File fout = new File("salida_compra_casas_usadas.json");
            File foutcsv = new File("salida_compra_casas_usadas.csv");
            File foutError = new File("salida_compra_casas_usadas_error.json");
            FileOutputStream fos = new FileOutputStream(fout);
            FileOutputStream fosError = new FileOutputStream(foutError);
            FileOutputStream fosCSV = new FileOutputStream(foutcsv);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
            BufferedWriter bwError = new BufferedWriter(new OutputStreamWriter(fosError, StandardCharsets.UTF_8));
            BufferedWriter bwCSV = new BufferedWriter(new OutputStreamWriter(fosCSV, StandardCharsets.UTF_8));

            String line = br.readLine();
            JSONObject json = new JSONObject(line);
            JSONArray arr = json.getJSONArray("list");

            bwCSV.write("Id;TipoOperacion;Region;Comuna;EstaPublicada;EstaEliminada;CodigoPropiedad;Dormitorios;Banos;AñoConstruccion;FechaPublicacionDespliegue;MetrosUtiles;MetrosConstruidos;MetrosTerreno;MetrosTerraza;PrecioDesde;PrecioHasta;PrecioPesos;PrecioUF;Latitud;Longitud;CantidadVisitas;CantidadFavoritos;CantidadInteresados;Exitosa;NombreCorredora;UriFicha");
            bwCSV.newLine();

            for (int i = 0; i < arr.length(); i++) {


                JSONObject detalle = arr.getJSONObject(i);
                String[] arrPropiedades = detalle.getString("url").split("/");
                String id = arrPropiedades[arrPropiedades.length - 1];

                String stringUrl = "https://www.toctoc.com/api/propiedades/usadas/" + id;
                URL url = new URL(stringUrl);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");
                uc.setRequestProperty("X-Requested-With", "Curl");
                uc.setRequestProperty("Host", "www.toctoc.com");
                uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
                uc.setRequestProperty("Accept", "*/*");
                uc.setRequestProperty("Accept-Language", "es-CL,es;q=0.8,en-US;q=0.5,en;q=0.3");
                uc.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
                uc.setRequestProperty("Referer", "https://www.toctoc.com/propiedades/arriendocorredorasr/departamento/santiago/bellas-artes-lastarria-dupl/761594");
                uc.setRequestProperty("X-XSRF-Token", "t3HXVFPIRevpAN45jKwZ1Z9h5iwfh2bD0r_Uuh-hkV6OLL1C1ewKMhYOiE2vN0AOgREXQ6xUVvS4BidfqIIcseYrWztBOmic_P5V1oVlRHc1");
                uc.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                uc.setRequestProperty("Connection", "keep-alive");
                uc.setRequestProperty("Cookie", "_ga=GA1.2.1323110744.1544624574; optimizelyEndUserId=oeu1544624944667r0.3818049908970317; optimizelySegments=%7B%222204271535%22%3A%22ff%22%2C%222215970531%22%3A%22false%22%2C%222232940041%22%3A%22direct%22%7D; optimizelyBuckets=%7B%7D; X-DATA=7313ae53-bc0f-4d23-aadf-1f7afb91df91; X-DATA-NPSW={\"CantidadVisitas\":1,\"FechaCreacion\":\"2019-01-02T16:06:46.3280839-03:00\",\"FechaUltimoIngreso\":\"2019-01-02T17:21:08.5818113-03:00\",\"Detalles\":[{\"TipoVistaNPS\":1,\"Cantidad\":1,\"FechaUltimoIngreso\":\"2019-01-02T16:06:46.3280839-03:00\"},{\"TipoVistaNPS\":2,\"Cantidad\":1,\"FechaUltimoIngreso\":\"2019-01-02T16:07:24.2436031-03:00\"},{\"TipoVistaNPS\":3,\"Cantidad\":7,\"FechaUltimoIngreso\":\"2019-01-02T17:21:08.5818113-03:00\"}]}; NPS_93546e30_last_seen=1546456029945; _gid=GA1.2.1801397619.1546456042; _fbp=fb.1.1546456044163.276844878; __RequestVerificationToken=pwNP3eaf0qlYOUSAFr1i2LL5yQYQ_sUpURh14Tau3e5zrrFL1c3LNXp0fJhXDsOT556mSzmVMHF1m6WPYJeNEqp0LPzP9T6GstiTXyif5lc1; NPS_93546e30_throttle=1546464016565; __insp_wid=2107690165; __insp_slim=1546460416746; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudG9jdG9jLmNvbS9wcm9waWVkYWRlcy9hcnJpZW5kb2NvcnJlZG9yYXNyL2RlcGFydGFtZW50by9zYW50aWFnby9iZWxsYXMtYXJ0ZXMtbGFzdGFycmlhLWR1cGwvNzYxNTk0; __insp_targlpt=RGVwYXJ0YW1lbnRvIGVuIGFycmllbmRvIGVuIFNhbnRpYWdvLCBCRUxMQVMgQVJURVMgLyBMQVNUQVJSSUEgRFVQTA%3D%3D; mp_29ae90688062e4e2e6d80b475cef8685_mixpanel=%7B%22distinct_id%22%3A%20%22167a2d24dd8190-0514def79cca76-4c312979-100200-167a2d24dd9145%22%2C%22%24device_id%22%3A%20%22167a2d24dd8190-0514def79cca76-4c312979-100200-167a2d24dd9145%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%7D; __insp_norec_sess=true; optimizelyPendingLogEvents=%5B%5D");
                uc.setRequestProperty("Cache-Control", "max-age=0");

                uc.addRequestProperty("Content-Type", "Application/JSON");
                uc.connect();
                int status = uc.getResponseCode();

                if(status == 200 || status == 201){
                    Reader reader;
                    if ("gzip".equals(uc.getContentEncoding())) {
                        reader = new InputStreamReader(new GZIPInputStream(uc.getInputStream()), StandardCharsets.UTF_8);
                    } else {
                        reader = new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8);
                    }

                    StringBuilder builder = new StringBuilder();
                    while (true) {
                        int ch = reader.read();
                        if (ch == -1) {
                            break;
                        }
                        builder.append((char)ch);
                    }
                    //bw.write(id+"->"+builder.toString());

                    JSONObject jsonProperties           = new JSONObject(builder.toString());
                    String NombreCorredora              = "";
                    String Comuna                       = "";
                    String Region                       = "";
                    String TipoOperacion                = "";
                    String FechaPublicacionDespliegue   = "";
                    String CodigoPropiedad              = "";
                    String UriFicha                     = "";
                    JSONObject Data;
                    JSONObject Propiedad;
                    JSONObject Estadistica;
                    double MetrosUtiles                 = 0.0;
                    double MetrosTerraza                = 0.0;
                    double MetrosConstruidos            = 0.0;
                    double MetrosTerreno                = 0.0;
                    double PrecioDesde                  = 0.0;
                    double PrecioHasta                  = 0.0;
                    double PrecioUF                     = 0.0;
                    double PrecioPesos                  = 0.0;
                    double Latitud                      = 0.0;
                    double Longitud                     = 0.0;
                    int Dormitorios                     = 0;
                    int Banos                           = 0;
                    int AnoConstruccion                 = 0;
                    int Id                              = 0;
                    int CantidadVisitas                 = 0;
                    int CantidadFavoritos               = 0;
                    int CantidadInteresados             = 0;
                    boolean EstaPublicada               = false;
                    boolean EstaEliminada               = false;
                    boolean Exitosa                     = false;

                    //if(!JSONObject.NULL.equals(jsonProperties.get("CodigoPropiedad"))){CodigoPropiedad = jsonProperties.getString("CodigoPropiedad");}
                    if(!JSONObject.NULL.equals(jsonProperties.get("UriFicha"))){UriFicha = jsonProperties.getString("UriFicha");}
                    if(!JSONObject.NULL.equals(jsonProperties.get("Data"))){Data = jsonProperties.getJSONObject("Data");
                        if(!JSONObject.NULL.equals(jsonProperties.get("Propiedad"))){Propiedad = Data.getJSONObject("Propiedad");
                            if(!JSONObject.NULL.equals(Propiedad.get("MetrosUtiles"))){MetrosUtiles = Propiedad.getDouble("MetrosUtiles");}
                            if(!JSONObject.NULL.equals(Propiedad.get("MetrosTerraza"))){MetrosTerraza = Propiedad.getDouble("MetrosTerraza");}
                            if(!JSONObject.NULL.equals(Propiedad.get("MetrosConstruidos"))){MetrosConstruidos = Propiedad.getDouble("MetrosConstruidos");}
                            if(!JSONObject.NULL.equals(Propiedad.get("MetrosTerreno"))){MetrosTerreno = Propiedad.getDouble("MetrosTerreno");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Dormitorios"))){Dormitorios = Propiedad.getInt("Dormitorios");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Banos"))){Banos = Propiedad.getInt("Banos");}
                            if(!JSONObject.NULL.equals(Propiedad.get("AñoConstruccion"))){AnoConstruccion = Propiedad.getInt("AñoConstruccion");}
                            if(!JSONObject.NULL.equals(Propiedad.get("NombreCorredora"))){NombreCorredora = Propiedad.getString("NombreCorredora");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Id"))){Id = Propiedad.getInt("Id");}
                            if(!JSONObject.NULL.equals(Propiedad.get("EstaPublicada"))){EstaPublicada = Propiedad.getBoolean("EstaPublicada");}
                            if(!JSONObject.NULL.equals(Propiedad.get("EstaEliminada"))){EstaEliminada = Propiedad.getBoolean("EstaEliminada");}
                            if(!JSONObject.NULL.equals(Propiedad.get("PrecioDesde"))){PrecioDesde = Propiedad.getDouble("PrecioDesde");}
                            if(!JSONObject.NULL.equals(Propiedad.get("PrecioHasta"))){PrecioHasta = Propiedad.getDouble("PrecioHasta");}
                            if(!JSONObject.NULL.equals(Propiedad.get("PrecioUF"))){PrecioUF = Propiedad.getDouble("PrecioUF");}
                            if(!JSONObject.NULL.equals(Propiedad.get("PrecioPesos"))){PrecioPesos = Propiedad.getDouble("PrecioPesos");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Comuna"))){Comuna = Propiedad.getString("Comuna");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Region"))){Region = Propiedad.getString("Region");}
                            if(!JSONObject.NULL.equals(Propiedad.get("TipoOperacion"))){TipoOperacion = Propiedad.getString("TipoOperacion");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Latitud"))){Latitud = Propiedad.getDouble("Latitud");}
                            if(!JSONObject.NULL.equals(Propiedad.get("Longitud"))){Longitud = Propiedad.getDouble("Longitud");}
                            if(!JSONObject.NULL.equals(Propiedad.get("FechaPublicacionDespliegue"))){FechaPublicacionDespliegue = Propiedad.getString("FechaPublicacionDespliegue");}
                        }
                        if(!JSONObject.NULL.equals(Data.get("Estadistica"))){Estadistica = Data.getJSONObject("Estadistica");
                            if(!JSONObject.NULL.equals(Estadistica.get("CantidadVisitas"))){CantidadVisitas = Estadistica.getInt("CantidadVisitas");}
                            if(!JSONObject.NULL.equals(Estadistica.get("CantidadFavoritos"))){CantidadFavoritos = Estadistica.getInt("CantidadFavoritos");}
                            if(!JSONObject.NULL.equals(Estadistica.get("CantidadInteresados"))){CantidadInteresados = Estadistica.getInt("CantidadInteresados");}
                        }
                        if(!JSONObject.NULL.equals(Data.get("Exitosa"))){Exitosa = Data.getBoolean("Exitosa");}
                    }

                    bwCSV.write(Id+";"+TipoOperacion+";"+Region+";"+Comuna+";"+EstaPublicada+";"+EstaEliminada+";"+CodigoPropiedad+";"+Dormitorios+";"+Banos+";"+AnoConstruccion+";"+FechaPublicacionDespliegue+";"+
                            MetrosUtiles+";"+MetrosConstruidos+";"+MetrosTerreno+";"+MetrosTerraza+";"+
                            PrecioDesde+";"+PrecioHasta+";"+PrecioPesos+";"+PrecioUF+";"+
                            Latitud+";"+Longitud+";"+CantidadVisitas+";"+CantidadFavoritos+";"+CantidadInteresados+";"+
                            Exitosa+";"+NombreCorredora+";"+UriFicha);
                    bwCSV.newLine();
                    bw.write(builder.toString());
                    bw.newLine();
                }else{
                    bwError.write(id+"->");
                    System.out.println(this.getClass().getName() + " Error " + i);
                }
                System.out.println(this.getClass().getName() + " Listo " + i + " de " + arr.length());
            }
            bw.close();
            bwError.close();
            bwCSV.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
