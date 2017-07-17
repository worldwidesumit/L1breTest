package Common;

import ApiTests.DocumentTests;
import ApiTests.NotificationTests;
import ApiTests.TripManagerTests;
import Base.BaseTestSuite;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Chetna on 7/5/2017.
 */
public class PayLoad extends BaseTestSuite{

        public static String getWebUserLoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassenger2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")+"\""+"}";
        return s;
    }


    public static String getPassenger1LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER1_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER1_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerChangeLocale() throws IOException {
        String s = "{\"locale\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_PASSENGER_LOCALE")
                +"\""+"}";
        return s;
    }

    public static String getPassengerChangePasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassenger2NewPassLoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerRevertPasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerGenerateTempDataBody() throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+"}";
        return s;
    }

    public static String getPassengerRefreshToken() throws IOException {
        String s = "{\"refresh_token\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_REFRESH_TOKEN")
                +"\""+"}";
        return s;
    }

    public static String getDocumentRenameBody() throws IOException {
        String s = "{\"fileName\":"+"\""+BaseTestSuite.getData().getProperty("NEWDOCUMENTNAME")
                +"\""+","+"\"documentId\":"+"\""+ DocumentTests.getDocumentId()+"\""+"}";
        return s;
    }

    public static String getDocumentAlreadyDeletedBody  () throws IOException {
        String s = "{\"documentId\":"+"\""+BaseTestSuite.getData().getProperty("ALREAD_DELETED_FILE_ID")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordEmailBody  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN3_EMAIL")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordUnameBody  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN3_USERNAME")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordFakeBody  () throws IOException {
        String s = "{\"email\":"+"\""+"RandomAndFake"
                +"\""+"}";
        return s;
    }

    public static String getWebuserUpdateBody() throws IOException {
        String s = "{\"firstName\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_FIRST_NAME")
                +"\""+","+"\"lastName\":"+"\""+ BaseTestSuite.getData().getProperty("TEMP_LAST_NAME")+"\""+"}";
        return s;
    }

    public static String getWebUserUpdateDuplicateEmail  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_EMAIL")
                +"\""+"}";
        return s;
    }

    public static String getWebuserUpdatePhoneBody() throws IOException {
        String s = "{\"countryCode\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_COUNTRYCODE")
                +"\""+","+"\"phoneNumber\":"+"\""+ BaseTestSuite.getData().getProperty("ADMIN2_PHONENUMBER")+"\""+"}";
        return s;
    }

    public static String getWebUserAdmin2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebusesrChangePasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebUserAdminLoginNewPasswordBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebusesrRevertPasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getDriverEmailbody  () throws IOException {
        String s = "{\n" +
                "  \"MODEL_TYPE\": \"driver\",\n" +
                "  \"username\": \"\",\n" +
                "  \"driverId\": \"\",\n" +
                "  \"name\": \"\",\n" +
                "  \"firstName\": \"Rodrigo\",\n" +
                "  \"lastName\": \"Pardo Fernandez\",\n" +
                "  \"shortName\": \"\",\n" +
                "  \"email\": \""+BaseTestSuite.getData().getProperty("DRIVER1_EMAIL")+"\",\n" +
                "  \"photo\": \"\",\n" +
                "  \"locale\": \"es_MX\",\n" +
                "  \"currentTaxiId\": \"\",\n" +
                "  \"currentTaxiInfo\": \"\",\n" +
                "  \"currentShiftId\": \"\",\n" +
                "  \"lastLoginTime\": null,\n" +
                "  \"lastLogoutTime\": null,\n" +
                "  \"rating\": 0,\n" +
                "  \"ratingsDoc\": {\n" +
                "    \n" +
                "  },\n" +
                "  \"forceChangePassword\": null,\n" +
                "  \"suspended\": null,\n" +
                "  \"countryCode\": \"+1\",\n" +
                "  \"phoneNumber\": \"123{{DRIVER1_PHONENUMBER}}\",\n" +
                "  \"phone\": \"\",\n" +
                "  \"rfc\": \"\",\n" +
                "  \"curp\": \"528983DC6B644027BF\",\n" +
                "  \"licenseId\": \"TEST-DRIVER01\",\n" +
                "  \"licenceExpiration\": 1525910400000,\n" +
                "  \"licenceType\": \"\",\n" +
                "  \"accessCardId\": \"\",\n" +
                "  \"dob\": 633887515407,\n" +
                "  \"cardCode\": \"\",\n" +
                "  \"licensePlate\": \"\",\n" +
                "  \"emergencyContacts\": \"\",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"bloodType\": \"AP\",\n" +
                "  \"mobileCountryCode\": \"\",\n" +
                "  \"mobilePhoneNumber\": \"\",\n" +
                "  \"vehicleOwner\": \"\",\n" +
                "  \"licenceOwner\": \"\",\n" +
                "  \"medicalInsurance\": \"\",\n" +
                "  \"medInsuranceCompany\": \"\",\n" +
                "  \"medExpirationDate\": null,\n" +
                "  \"tarjetonId\": \"WM409801\",\n" +
                "  \"tarjetonType\": \"PP\",\n" +
                "  \"tarjetonExpDate\": 1738425171322,\n" +
                "  \"streetAddress\": \"1115 Laidlaw Dr\",\n" +
                "  \"intNum\": \"\",\n" +
                "  \"extNum\": \"11\",\n" +
                "  \"community\": \"Milton\",\n" +
                "  \"municipality\": \"Halton\",\n" +
                "  \"zipcode\": \"90210\",\n" +
                "  \"state\": \"ON\",\n" +
                "  \"_yz_rk\": \"\",\n" +
                "  \"disableExpiryDate\": true,\n" +
                "  \"loading\": false,\n" +
                "  \"noResponse\": false,\n" +
                "  \"notFound\": false,\n" +
                "  \"readonly\": true,\n" +
                "  \"whiteout\": false,\n" +
                "  \"alreadyInDB\": false,\n" +
                "  \"licenceExpiration_valid\": true,\n" +
                "  \"dob_valid\": true,\n" +
                "  \"tarjetonExpDate_valid\": true,\n" +
                "  \"medExpirationDate_valid\": true,\n" +
                "  \"goodToGo\": true\n" +
                "}";
        return s;
    }

    public static String getDriverNewPhoneEmail() throws IOException {
        String s = "{\n" +
                "  \"MODEL_TYPE\": \"driver\",\n" +
                "  \"username\": \"\",\n" +
                "  \"driverId\": \"\",\n" +
                "  \"name\": \"\",\n" +
                "  \"firstName\": \"Rodrigo\",\n" +
                "  \"lastName\": \"Pardo Fernandez\",\n" +
                "  \"shortName\": \"\",\n" +
                "  \"email\": \"notExistingDriver@gmail.com\",\n" +
                "  \"photo\": \"\",\n" +
                "  \"locale\": \"es_MX\",\n" +
                "  \"currentTaxiId\": \"\",\n" +
                "  \"currentTaxiInfo\": \"\",\n" +
                "  \"currentShiftId\": \"\",\n" +
                "  \"lastLoginTime\": null,\n" +
                "  \"lastLogoutTime\": null,\n" +
                "  \"rating\": 0,\n" +
                "  \"ratingsDoc\": {\n" +
                "    \n" +
                "  },\n" +
                "  \"forceChangePassword\": null,\n" +
                "  \"suspended\": null,\n" +
                "  \"countryCode\": \"+67\",\n" +
                "  \"phoneNumber\": \"8907654563\",\n" +
                "  \"phone\": \"\",\n" +
                "  \"rfc\": \"\",\n" +
                "  \"curp\": \"528983DC6B644027BF\",\n" +
                "  \"licenseId\": \"TEST-DRIVER01\",\n" +
                "  \"licenceExpiration\": 1525910400000,\n" +
                "  \"licenceType\": \"\",\n" +
                "  \"accessCardId\": \"\",\n" +
                "  \"dob\": 633887515407,\n" +
                "  \"cardCode\": \"\",\n" +
                "  \"licensePlate\": \"\",\n" +
                "  \"emergencyContacts\": \"\",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"bloodType\": \"AP\",\n" +
                "  \"mobileCountryCode\": \"\",\n" +
                "  \"mobilePhoneNumber\": \"\",\n" +
                "  \"vehicleOwner\": \"\",\n" +
                "  \"licenceOwner\": \"\",\n" +
                "  \"medicalInsurance\": \"\",\n" +
                "  \"medInsuranceCompany\": \"\",\n" +
                "  \"medExpirationDate\": null,\n" +
                "  \"tarjetonId\": \"WM409801\",\n" +
                "  \"tarjetonType\": \"PP\",\n" +
                "  \"tarjetonExpDate\": 1738425171322,\n" +
                "  \"streetAddress\": \"1115 Laidlaw Dr\",\n" +
                "  \"intNum\": \"\",\n" +
                "  \"extNum\": \"11\",\n" +
                "  \"community\": \"Milton\",\n" +
                "  \"municipality\": \"Halton\",\n" +
                "  \"zipcode\": \"90210\",\n" +
                "  \"state\": \"ON\",\n" +
                "  \"_yz_rk\": \"\",\n" +
                "  \"disableExpiryDate\": true,\n" +
                "  \"loading\": false,\n" +
                "  \"noResponse\": false,\n" +
                "  \"notFound\": false,\n" +
                "  \"readonly\": true,\n" +
                "  \"whiteout\": false,\n" +
                "  \"alreadyInDB\": false,\n" +
                "  \"licenceExpiration_valid\": true,\n" +
                "  \"dob_valid\": true,\n" +
                "  \"tarjetonExpDate_valid\": true,\n" +
                "  \"medExpirationDate_valid\": true,\n" +
                "  \"goodToGo\": true\n" +
                "}";
        return s;
    }

    public static Timestamp getTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.getTime();
        return  timestamp;

    }

    public static String getDriver2SuspendBody() throws IOException {
        String s = "{\n" +"\"suspended\": \"true\"\n" +"}";
        return s;
    }

    public static String getDriver2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getDriver2UnSuspendBody() throws IOException {
        String s = "{\n" +"\"suspended\": \"false\"\n" +"}";
        return s;
    }

    public static String getDriverZipCodeBody() throws IOException {
        String s = "{\"zipcode\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_ZIP_CODE")
                +"\""+"}";
        return s;
    }
    public static String getDriver1LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_PASSWORD")+"\""+"}";
        return s;
    }
    public static String getDriverReplaceEmerContactsBody() throws IOException {
        String s = "{{\n" +
                "\"contacts\":[],\n" +
                "\"replace\":true\n" +
                "}";
        return s;
    }

    public static String getDriverShiftsTaxi1Body() throws IOException {
        String s = "{\"taxiId\":"+"\""+BaseTestSuite.getData().getProperty("TAXI1_TAXIID")
                +"\""+","+"\"shiftId\":"+"\""+getTimeStamp().getTime()+"\""+"}";
        return s;
    }

    public static String getTripDriver1BookTaxi1Body() throws IOException {
        String s = "{\"taxiId\":"+"\""+BaseTestSuite.getData().getProperty("TAXI1_TAXIID")
                +"\""+","+"\"driverId\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_DRIVERID")+"\""+"}";
        return s;
    }

    public static String getTripCancelTripBody() throws IOException {
        String s = "{\"tripId\":"+"\""+ TripManagerTests.getTRIPID()
                +"\""+"}";
        return s;
    }

    public static String getTripTrip2EndBody() throws IOException {
        String s = "{\n" +
                "\"tripCostSummary\":{\n" +
                "\"baseFare\": 5.50,\n" +
                "\"distance\": 4.25,\n" +
                "\"time\": 6.50, \n" +
                "\"wifiCost\": 3,\n" +
                "\"total\":" +BaseTestSuite.getData().getProperty("TEMP_TOTAL_COST")+"\n" +
                "},\n" +
                "\"tripDistance\": 50,\n" +
                "\"isWiFiConsumed\": true\n" +
                "}";
        return s;
    }

    public static String getTripDriver1RateTrip2Body() throws IOException {
        String s = "{\"rating\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_DRIVER_RATE")
                +"\""+"}";
        return s;
    }

    public static String getTripPassengerRatingBody() throws IOException {
        String s = "{\"rating\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_PASSENGER_TABLET_RATE")
                +"\""+","+"\"passengerTablet\":"+"\""+true+"\""+"}";
        return s;
    }
    public static String getNotifAdminDriverBody() throws IOException {
        String s = "{\"driverId\":"+"\""+ NotificationTests.getDriverId()
                +"\""+","+"\"msg\":"+"\""+BaseTestSuite.getData().getProperty("MESSAGE_FOR_ONE_DRIVER")+"\""+"}";
        return s;
    }

    public static String getNotifAdminBroadCastDriverBody() throws IOException {
        String s = "{\n" +
                "\"lat\" : \"43.647861\",\n" +
                "\"lng\": \"-79.382019\",\n" +
                "\"msg\" : \""+BaseTestSuite.getData().getProperty("BROAD_CAST_MESSAGE")+"\",\n" +
                "\"dist\": \"1\"\n" +
                "}";
        return s;
    }

    public static String getNotifDriverShiftBody() throws IOException {
        String s = "{\"taxiId\":"+"\""+ BaseTestSuite.getData().getProperty("NOTIFICATION_TAXI_24858_ID")
                +"\""+","+"\"shiftId\":"+"\""+getTimeStamp().getTime()+"\""+"}";
        return s;
    }

    public static String getNotifAdminForceShiftOutBody() throws IOException {
        String s = "{\"driverId\":"+"\""+ NotificationTests.getDriverId()
                +"\""+","+"\"shiftId\":"+"\""+NotificationTests.getDriverShiftId()+"\""+"}";
        return s;
    }

    public static String getPdfGeneratePdf() throws IOException{
        String s = "{\"clientId\":\"libre\",\"clientTemplate\":\"commissionReport\"," +
                "\"data\":{\"driver\":{\"username\":\"acaballero147\"," +
                "\"driverId\":\"6005b605-1e07-48b0-8545-28bf37d28ed3\"," +
                "\"name\":\"Alex Alonso Caballero\",\"firstName\":\"Alex\"," +
                "\"lastName\":\"Alonso Caballero\",\"secondLastName\":\"\"," +
                "\"shortName\":\"Alex A.\",\"email\":\"Emilio@gmail.com\"," +
                "\"photo\":\"/public/css/images/administration/ic_nodriver.svg\"," +
                "\"locale\":\"es_MX\",\"currentTaxiId\":\"\",\"currentTaxiInfo\":\"\"," +
                "\"currentShiftId\":\"\",\"lastLoginTime\":null,\"lastLogoutTime\":null," +
                "\"rating\":0,\"ratingsDoc\":{},\"forceChangePassword\":true,\"suspended\":false," +
                "\"isSemoviValidated\":true,\"createdOn\":\"2017-05-13T20:18:39.000Z\"," +
                "\"updatedOn\":\"2017-06-16T21:10:53.000Z\",\"_yz_rb\":\"driver\",\"_yz_rt\":\"default\"," +
                "\"_yz_rk\":\"6005b605-1e07-48b0-8545-28bf37d28ed3\",\"countryCode\":\"+1\"," +
                "\"phoneNumber\":\"9810726006\",\"phone\":\"+19810726006\",\"rfc\":\"AHGHGHG78666\"," +
                "\"isRfcRegistered\":false,\"licenseId\":\"TEST-Driver1\",\"licenceExpiration\":\"13/05/2018\"," +
                "\"tarjetonId\":\"er8686698986608\",\"dob\":\"19/01/1985\",\"cardCode\":\"\",\"licensePlate\":\"\"," +
                "\"tarjetonType\":\"Pasaporte\",\"curp\":\"47B9A77603F8989777\"," +
                "\"emergencyContacts\":[],\"gender\":\"M\",\"bloodType\":\"\",\"mobileCountryCode\":\"\"," +
                "\"mobilePhoneNumber\":\"\",\"vehicleOwner\":\"\",\"licenceOwner\":\"\"," +
                "\"medicalInsurance\":\"\",\"medInsuranceCompany\":\"\",\"medExpirationDate\":\"\"," +
                "\"tarjetonExpDate\":\"01/01/2026\",\"licenceType\":\"B\",\"streetAddress\":\"50 Town Center\"," +
                "\"intNum\":\"90\",\"extNum\":\"78\",\"community\":\"Highwell Community\"," +
                "\"municipality\":\"Decorum Municipality\",\"zipcode\":\"90765\",\"state\":\"New Mexico\"," +
                "\"bankingInfoStreetAddress\":\"50\",\"bankingInfoIntNum\":\"IN4567\",\"bankingInfoExtNum\":\"test\"," +
                "\"bankingInfoCommunity\":\"Purple Hills\",\"bankingInfoMunicipality\":\"Test\"," +
                "\"bankingInfoState\":\"New Mexico\",\"bankingInfoZipcode\":\"78676\"," +
                "\"bankingInfoRelationship\":\"Brother\",\"bankingInfoFirstName\":\"Armando\"," +
                "\"bankingInfoLastName\":\"Sergio\",\"bankingInfoSecondLastName\":\"Test\"," +
                "\"bankingInfoDob\":\"19/02/1983\",\"officialTarjetonNumber\":\"76786876868687687687\"," +
                "\"officialTarjetonExpDate\":\"01/01/2024\",\"issuingCountry\":\"México\"," +
                "\"displayIssuingCountry\":\"none\"}," +
                "\"taxi\":{\"tripId\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369_1498762076680\"," +
                "\"cellId\":\"882b34d\",\"timestamp\":1498762984878,\"eta\":0," +
                "\"loc\":\"43.648244524374604,-79.38202885910869\",\"heading\":253,\"speed\":1073741824," +
                "\"status\":1,\"taxiId\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\",\"companyId\":\"l1bre\"," +
                "\"wheelchair\":false,\"driverTabletIMEI\":\"895945485749438\",\"driverTabletSN\":\"R52GB016MKD\"," +
                "\"passengerTabletSN\":\"H1001713000504\",\"driverTabletID\":\"TKPED6\",\"make\":\"Fiat\"," +
                "\"model\":\"Edge\",\"fareType\":\"Calle\",\"modelYear\":\"2016\",\"capacity\":4,\"fuelType\":\"\"," +
                "\"vin\":\"TESTLINDA11388657\",\"curp\":\"8E5AF960B2584A5092\",\"licensePlate\":\"TEST-LINDA1\"," +
                "\"type\":\"sedan\",\"voltageOn\":\"ON01\",\"voltageOff\":\"OFF1\",\"rizo\":\"\",\"notes\":\"\"," +
                "\"appInfo\":{\"versionName\":\"1.4.1\",\"versionCode\":\"40\"},\"owner\":\"P\"," +
                "\"insuranceCompany\":\"\",\"insuranceExpiration\":\"\",\"mileage\":\"Mill\",\"condition\":\"\"," +
                "\"isSemoviValidated\":true,\"registrationNumber\":1231,\"_yz_rb\":\"taxi\",\"_yz_rt\":\"default\"," +
                "\"_yz_rk\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\",\"personFirstName\":\"Alex\"," +
                "\"personMiddleName\":\"\",\"personLastName\":\"Alonso Caballero\",\"personSecondLastName\":\"\"," +
                "\"personDob\":\"19/01/1985\",\"personGender\":\"M\",\"personHomeCountryCode\":\"+52\"," +
                "\"personHomePhoneNumber\":\"9878766765\",\"personMobileCountryCode\":\"\"," +
                "\"personMobilePhoneNumber\":\"\",\"personBloodType\":\"\",\"personRfc\":\"\",\"personCurp\":\"\"," +
                "\"personAddrStreet\":\"50 Town Center\",\"personAddrExteriorNum\":\"78\"," +
                "\"personAddrInteriorNum\":\"90\",\"personAddrCommunity\":\"Highwell Community\"," +
                "\"personAddrMunicipality\":\"Decorum Municipality\",\"personAddrZipcode\":\"90765\"," +
                "\"personAddrState\":\"New Mexico\",\"companyName\":\"\",\"companyRfc\":\"\"," +
                "\"companyAddrStreet\":\"\",\"companyAddrExteriorNum\":\"\",\"companyAddrInteriorNum\":\"\"," +
                "\"companyAddrCommunity\":\"\",\"companyAddrMunicipality\":\"\",\"companyAddrZipcode\":\"\"," +
                "\"companyAddrState\":\"\",\"companyOfficeCountryCode\":\"\",\"companyOfficePhoneNumber\":\"\"," +
                "\"companyLegalRepName\":\"\",\"companyLegalRepRfc\":\"\",\"createdOn\":\"2017-05-24T16:11:25.000Z\"," +
                "\"updatedOn\":\"2017-06-29T12:57:49.000Z\",\"personOwnerDisplay\":\"block\"," +
                "\"companyOwnerDisplay\":\"none\"}," +
                "\"hardware\":{\"passengerTablet\":{\"serialNumber\":\"H1001713000504\",\"type\":\"passenger\"," +
                "\"support\":\"\",\"supportVersion\":\"\"," +
                "\"currentTaxiId\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\"," +
                "\"currentTaxiInfo\":{\"licensePlate\":\"TEST-LINDA1\",\"type\":\"sedan\"},\"installationKit\":\"\"," +
                "\"brand\":\"Ingram\",\"model\":\"1345\",\"version\":\"\",\"carrier\":\"\",\"imei\":null," +
                "\"sim\":null,\"simSerialNumber\":\"\",\"c5\":\"\",\"powerSourceVersion\":\"\"," +
                "\"paymentTerminal\":\"\",\"createdOn\":1497012620352,\"_yz_rb\":\"tablet\",\"_yz_rt\":\"default\"," +
                "\"_yz_rk\":\"H1001713000504\"},\"driverTablet\":{\"serialNumber\":\"R52GB016MKD\"," +
                "\"type\":\"driver\",\"support\":\"\",\"supportVersion\":\"\"," +
                "\"currentTaxiId\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\"," +
                "\"currentTaxiInfo\":{\"licensePlate\":\"TEST-LINDA1\",\"type\":\"sedan\"},\"installationKit\":\"\"," +
                "\"brand\":\"Ingram\",\"model\":\"Galaxy\",\"version\":\"\",\"carrier\":\"\"," +
                "\"imei\":\"895945485749438\",\"sim\":\"34334567890\",\"simSerialNumber\":\"\",\"c5\":\"\"," +
                "\"powerSourceVersion\":\"\",\"paymentTerminal\":\"\",\"createdOn\":1496865606831," +
                "\"_yz_rb\":\"tablet\",\"_yz_rt\":\"default\",\"_yz_rk\":\"R52GB016MKD\"}}," +
                "\"installationDetails\":{\"installationRecordId\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\"," +
                "\"taxiLicensePlate\":\"TEST-LINDA1\",\"driverId\":\"6005b605-1e07-48b0-8545-28bf37d28ed3\"," +
                "\"installationSite\":\"InstallationE34\",\"installationDate\":\"09/06/2017\"," +
                "\"installationStartTime\":\"16:35\",\"installationEndTime\":null,\"softwareVersion\":null," +
                "\"technicianFirstName\":\"TECH\",\"technicianMiddleName\":null,\"technicianLastName\":\"TEAM\"," +
                "\"technicianSecondLastName\":null," +
                "\"technicianMiscMaterialsUsed\":null,\"technicianRemarks\":\"Good\"," +
                "\"technicianServiceType\":\"Instalación\",\"trainerFirstName\":\"Trainner\"," +
                "\"trainerMiddleName\":null,\"trainerLastName\":\"Details\",\"trainerSecondLastName\":null," +
                "\"qaSupervisorFirstName\":null,\"qaSupervisorMiddleName\":null,\"qaSupervisorLastName\":null," +
                "\"qaSupervisorSecondLastName\":null,\"createdOn\":1497040586523,\"updatedOn\":1497040586523" +
                ",\"_yz_rb\":\"installationRecord\",\"_yz_rt\":\"default\"," +
                "\"_yz_rk\":\"taxi_0c4f6593-7b69-40a1-b7a9-eccc9a47a369\"}}}\n";
                return s;

    }

    public static String getUserProfileAddUserBody() throws IOException {
        String s = "{\"userName\":"+"\""+BaseTestSuite.getData().getProperty("USERPROFILE_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("USERPROFILE_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getUserProfileChangePassword() throws IOException {
        String s = "{\"userName\":"+"\""+BaseTestSuite.getData().getProperty("USERPROFILE_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_PASSWORD")+"\""+"}";
        return s;
    }






}
