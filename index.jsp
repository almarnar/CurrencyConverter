<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Currency Converter </title>
        <style type="text/css">
            <!--
            .style4 {font-size: 16px}
            body {
                background-color: #FFFFCC;
            }
            -->
        </style>
    </head>
    <body>
        <div id="container1" align="center" style="width:auto">
            <h1>Currency Converter Widget</h1>
        </div>
        <div id="container2" style="background-color:#CC99CC; margin-left:450px; height:250px;width:350px;float:left; text-align:center">
            <form name="Form" action="Converter" method="get"  >
                <p>&nbsp;<strong>From<span class="style4">:</span></strong> &nbsp; &nbsp;
                    <select name="from">
                        <option value="USD">USD, US Dollar</option>
                        <option value="JPY">JPY, Japanese Yen</option>
                        <option value="BGN">BGN, Bulgarian Lev</option>
                        <option value="BRL">BRL, Brazilian Real</option>
                        <option value="CZK">CZK, Czech Republic </option>
                        <option value="DKK">DKK, Danish Krone</option>
                        <option value="GBP">GBP, British Pound </option>
                        <option value="HUF">HUF, Hungarian Forint</option>
                        <option value="LTL">LTL, Lithuanian Litas</option>
                        <option value="PLN">PLN, Polish Zloty</option>
                        <option value="RON">RON, Romanian Leu</option>
                        <option value="SEK">SEK, Swedish Krona</option>
                        <option value="CHF">CHF, Swiss Franc</option>
                        <option value="NOK">NOK, Norwegian Krone</option>
                        <option value="HRK">HRK, Croatian Kuna</option>
                        <option value="RUB">RUB, Russian Ruble</option>
                        <option value="TRY">TRY, Turkish Lira</option>
                        <option value="AUD">AUD, Australian Dollar</option>
                        <option value="BRL">BRL, Brazilian Real</option>
                        <option value="CAD">CAD, Canadian Dollar</option>
                        <option value="CNY">CNY, Chinese Yuan Renminbi</option>
                        <option value="HKD">HKD, Hong Kong Dollar</option>
                        <option value="IDR">IDR, Indonesian Rupiah</option>
                        <option value="ILS">ILS, Israeli New Sheqel</option>
                        <option value="INR">INR, Indian Rupee</option>
                        <option value="KRW">KRW, South Korean Won</option>
                        <option value="MXN">MXN, Mexican Peso</option>
                        <option value="MYR">MYR, Malaysian Ringgit</option>
                        <option value="NZD">NZD, New Zealand Dollar</option>
                        <option value="PHP">PHP, PhilippBrunei Dollarine Peso</option>
                        <option value="SGD">SGD, Singapore Dollar</option>
                        <option value="THB">THB, Thai Baht</option>
                        <option value="ZAR">ZAR, South African Ran</option>
                        <option value="EUR">EUR, Euro</option>    
                    </select>
                    <br> 
                </p>
                <p>&nbsp;<strong>To:</strong>&nbsp;&nbsp;&nbsp;
                    <select name="to">
                        <option value="USD">USD, US Dollar</option>
                        <option value="JPY">JPY, Japanese Yen</option>
                        <option value="BGN">BGN, Bulgarian Lev</option>
                        <option value="BRL">BRL, Brazilian Real</option>
                        <option value="CZK">CZK, Czech Republic </option>
                        <option value="DKK">DKK, Danish Krone</option>
                        <option value="GBP">GBP, British Pound </option>
                        <option value="HUF">HUF, Hungarian Forint</option>
                        <option value="LTL">LTL, Lithuanian Litas</option>
                        <option value="PLN">PLN, Polish Zloty</option>
                        <option value="RON">RON, Romanian Leu</option>
                        <option value="SEK">SEK, Swedish Krona</option>
                        <option value="CHF">CHF, Swiss Franc</option>
                        <option value="NOK">NOK, Norwegian Krone</option>
                        <option value="HRK">HRK, Croatian Kuna</option>
                        <option value="RUB">RUB, Russian Ruble</option>
                        <option value="TRY">TRY, Turkish Lira</option>
                        <option value="AUD">AUD, Australian Dollar</option>
                        <option value="BRL">BRL, Brazilian Real</option>
                        <option value="CAD">CAD, Canadian Dollar</option>
                        <option value="CNY">CNY, Chinese Yuan Renminbi</option>
                        <option value="HKD">HKD, Hong Kong Dollar</option>
                        <option value="IDR">IDR, Indonesian Rupiah</option>
                        <option value="ILS">ILS, Israeli New Sheqel</option>
                        <option value="INR">INR, Indian Rupee</option>
                        <option value="KRW">KRW, South Korean Won</option>
                        <option value="MXN">MXN, Mexican Peso</option>
                        <option value="MYR">MYR, Malaysian Ringgit</option>
                        <option value="NZD">NZD, New Zealand Dollar</option>
                        <option value="PHP">PHP, PhilippBrunei Dollarine Peso</option>
                        <option value="SGD">SGD, Singapore Dollar</option>
                        <option value="THB">THB, Thai Baht</option>
                        <option value="ZAR">ZAR, South African Ran</option>
                        <option value="EUR">EUR, Euro</option>    
                    </select>
                </p>
                <p>
                    &nbsp;<strong>Amount: </strong>&nbsp;&nbsp;&nbsp;
                    <input type="text" name="amount" value=""/>
                    &nbsp;</p>
                
                <p> 
                    <input type="Submit" value="Convert" onclick="Converter" />
                    &nbsp; 
                    <input type="Text" value="<%= request.getParameter("result")%>" >
                </p>
            </form>
            <form name="Form2" action="Report5" method="get"  >
                <p> 
                    <input type="Submit" value="Info" onclick="Report5" />
                    &nbsp; 
                </p>
            </form>
               <form name="Form3" action="Code" method="get"  >
                <p> 
                    <input type="Submit" value="Code" onclick="Code" />
                    &nbsp; 
                </p>
            </form> 
        </div>
    </body>
</html>