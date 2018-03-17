package com.kulizaassignment.test_utils;

import com.google.gson.Gson;
import com.kulizaassignment.data.pojo.Weather;

/**
 * Created by saransh on 18/03/18.
 */

public class Utils {
    public static Weather initializeData() {
        String json="{\n" +
                "    \"location\": {\n" +
                "        \"name\": \"Bengaluru\",\n" +
                "        \"region\": \"Karnataka\",\n" +
                "        \"country\": \"India\",\n" +
                "        \"lat\": 12.98,\n" +
                "        \"lon\": 77.58,\n" +
                "        \"tz_id\": \"Asia/Kolkata\",\n" +
                "        \"localtime_epoch\": 1521316728,\n" +
                "        \"localtime\": \"2018-03-18 1:28\"\n" +
                "    },\n" +
                "    \"current\": {\n" +
                "        \"last_updated_epoch\": 1521315934,\n" +
                "        \"last_updated\": \"2018-03-18 01:15\",\n" +
                "        \"temp_c\": 20,\n" +
                "        \"temp_f\": 68,\n" +
                "        \"is_day\": 0,\n" +
                "        \"condition\": {\n" +
                "            \"text\": \"Partly cloudy\",\n" +
                "            \"icon\": \"//cdn.apixu.com/weather/64x64/night/116.png\",\n" +
                "            \"code\": 1003\n" +
                "        },\n" +
                "        \"wind_mph\": 0,\n" +
                "        \"wind_kph\": 0,\n" +
                "        \"wind_degree\": 121,\n" +
                "        \"wind_dir\": \"ESE\",\n" +
                "        \"pressure_mb\": 1015,\n" +
                "        \"pressure_in\": 30.4,\n" +
                "        \"precip_mm\": 3.5,\n" +
                "        \"precip_in\": 0.14,\n" +
                "        \"humidity\": 100,\n" +
                "        \"cloud\": 50,\n" +
                "        \"feelslike_c\": 20,\n" +
                "        \"feelslike_f\": 68,\n" +
                "        \"vis_km\": 6,\n" +
                "        \"vis_miles\": 3\n" +
                "    },\n" +
                "    \"forecast\": {\n" +
                "        \"forecastday\": [\n" +
                "            {\n" +
                "                \"date\": \"2018-03-18\",\n" +
                "                \"date_epoch\": 1521331200,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 28.2,\n" +
                "                    \"maxtemp_f\": 82.8,\n" +
                "                    \"mintemp_c\": 21.4,\n" +
                "                    \"mintemp_f\": 70.5,\n" +
                "                    \"avgtemp_c\": 24.7,\n" +
                "                    \"avgtemp_f\": 76.4,\n" +
                "                    \"maxwind_mph\": 10.1,\n" +
                "                    \"maxwind_kph\": 16.2,\n" +
                "                    \"totalprecip_mm\": 10.8,\n" +
                "                    \"totalprecip_in\": 0.43,\n" +
                "                    \"avgvis_km\": 18.1,\n" +
                "                    \"avgvis_miles\": 11,\n" +
                "                    \"avghumidity\": 71,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Light rain shower\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/353.png\",\n" +
                "                        \"code\": 1240\n" +
                "                    },\n" +
                "                    \"uv\": 13.2\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:25 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"06:59 AM\",\n" +
                "                    \"moonset\": \"07:20 PM\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2018-03-19\",\n" +
                "                \"date_epoch\": 1521417600,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 30.7,\n" +
                "                    \"maxtemp_f\": 87.3,\n" +
                "                    \"mintemp_c\": 22.1,\n" +
                "                    \"mintemp_f\": 71.8,\n" +
                "                    \"avgtemp_c\": 25.8,\n" +
                "                    \"avgtemp_f\": 78.4,\n" +
                "                    \"maxwind_mph\": 10.1,\n" +
                "                    \"maxwind_kph\": 16.2,\n" +
                "                    \"totalprecip_mm\": 0,\n" +
                "                    \"totalprecip_in\": 0,\n" +
                "                    \"avgvis_km\": 20,\n" +
                "                    \"avgvis_miles\": 12,\n" +
                "                    \"avghumidity\": 55,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Partly cloudy\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/116.png\",\n" +
                "                        \"code\": 1003\n" +
                "                    },\n" +
                "                    \"uv\": 14.5\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:25 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"07:42 AM\",\n" +
                "                    \"moonset\": \"08:12 PM\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2018-03-20\",\n" +
                "                \"date_epoch\": 1521504000,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 31.7,\n" +
                "                    \"maxtemp_f\": 89.1,\n" +
                "                    \"mintemp_c\": 23,\n" +
                "                    \"mintemp_f\": 73.4,\n" +
                "                    \"avgtemp_c\": 26.8,\n" +
                "                    \"avgtemp_f\": 80.2,\n" +
                "                    \"maxwind_mph\": 9.6,\n" +
                "                    \"maxwind_kph\": 15.5,\n" +
                "                    \"totalprecip_mm\": 0,\n" +
                "                    \"totalprecip_in\": 0,\n" +
                "                    \"avgvis_km\": 20,\n" +
                "                    \"avgvis_miles\": 12,\n" +
                "                    \"avghumidity\": 44,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Partly cloudy\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/116.png\",\n" +
                "                        \"code\": 1003\n" +
                "                    },\n" +
                "                    \"uv\": 14.8\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:24 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"08:26 AM\",\n" +
                "                    \"moonset\": \"09:05 PM\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2018-03-21\",\n" +
                "                \"date_epoch\": 1521590400,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 32.8,\n" +
                "                    \"maxtemp_f\": 91,\n" +
                "                    \"mintemp_c\": 23.9,\n" +
                "                    \"mintemp_f\": 75,\n" +
                "                    \"avgtemp_c\": 27.7,\n" +
                "                    \"avgtemp_f\": 81.9,\n" +
                "                    \"maxwind_mph\": 9.6,\n" +
                "                    \"maxwind_kph\": 15.5,\n" +
                "                    \"totalprecip_mm\": 0,\n" +
                "                    \"totalprecip_in\": 0,\n" +
                "                    \"avgvis_km\": 20,\n" +
                "                    \"avgvis_miles\": 12,\n" +
                "                    \"avghumidity\": 40,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Partly cloudy\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/116.png\",\n" +
                "                        \"code\": 1003\n" +
                "                    },\n" +
                "                    \"uv\": 14.5\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:23 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"09:12 AM\",\n" +
                "                    \"moonset\": \"10:01 PM\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2018-03-22\",\n" +
                "                \"date_epoch\": 1521676800,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 32.5,\n" +
                "                    \"maxtemp_f\": 90.5,\n" +
                "                    \"mintemp_c\": 24.6,\n" +
                "                    \"mintemp_f\": 76.3,\n" +
                "                    \"avgtemp_c\": 28.5,\n" +
                "                    \"avgtemp_f\": 83.3,\n" +
                "                    \"maxwind_mph\": 8.9,\n" +
                "                    \"maxwind_kph\": 14.4,\n" +
                "                    \"totalprecip_mm\": 0,\n" +
                "                    \"totalprecip_in\": 0,\n" +
                "                    \"avgvis_km\": 20,\n" +
                "                    \"avgvis_miles\": 12,\n" +
                "                    \"avghumidity\": 40,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Partly cloudy\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/116.png\",\n" +
                "                        \"code\": 1003\n" +
                "                    },\n" +
                "                    \"uv\": 39960\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:23 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"10:01 AM\",\n" +
                "                    \"moonset\": \"10:58 PM\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2018-03-23\",\n" +
                "                \"date_epoch\": 1521763200,\n" +
                "                \"day\": {\n" +
                "                    \"maxtemp_c\": 32.9,\n" +
                "                    \"maxtemp_f\": 91.2,\n" +
                "                    \"mintemp_c\": 22.6,\n" +
                "                    \"mintemp_f\": 72.7,\n" +
                "                    \"avgtemp_c\": 28.4,\n" +
                "                    \"avgtemp_f\": 83,\n" +
                "                    \"maxwind_mph\": 12.3,\n" +
                "                    \"maxwind_kph\": 19.8,\n" +
                "                    \"totalprecip_mm\": 0,\n" +
                "                    \"totalprecip_in\": 0,\n" +
                "                    \"avgvis_km\": 20,\n" +
                "                    \"avgvis_miles\": 12,\n" +
                "                    \"avghumidity\": 35,\n" +
                "                    \"condition\": {\n" +
                "                        \"text\": \"Partly cloudy\",\n" +
                "                        \"icon\": \"//cdn.apixu.com/weather/64x64/day/116.png\",\n" +
                "                        \"code\": 1003\n" +
                "                    },\n" +
                "                    \"uv\": 39960\n" +
                "                },\n" +
                "                \"astro\": {\n" +
                "                    \"sunrise\": \"06:22 AM\",\n" +
                "                    \"sunset\": \"06:30 PM\",\n" +
                "                    \"moonrise\": \"10:53 AM\",\n" +
                "                    \"moonset\": \"11:57 PM\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        Gson g = new Gson();
        //Weather weather=new Weather(json);
        return g.fromJson(json, Weather.class);
    }

}
