package com.commdel.carservicewale.util;


import android.text.InputType;
import android.widget.Toast;

import com.commdel.carservicewale.App;
import com.commdel.carservicewale.networking.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C {


    public static final String URL = "url";
    public static final String RURL = "rurl";
    public static final String BASE_URL = "https://carservice.testing-demo.com/";
    public static final String NOWNOW_NARRATION = "NOWNOW WALLET TOPUP";
    public static final String GOOGLE_PLAY_STORE_ID = "4002";
    public static final String I_TUNE_ID = "4001";
    public static final String GOOGLE_PLAY_STORE_NAME = "Google Play ";
    public static final String I_TUNE_NAME = "iTune ";
    public static final String SCREENNAME = "screenname";
    public static final String UNREGISTERED_USER = "Unregistered User";

    public static final String SPLASH_ACTION = "com.nownow.android.Splash";
    public static final String UPDATE_IMAGE = "com.nownow.android.update_image";
    public static final int REQUEST_CODE_UPDATE_IMAGE = 9001;
    public static final String AIICO_INSURANCE_HEALTH_PROD = "8062";
    public static final String IS_UPDATED = "is_updated";

    public static final String CHANNEL_ID = "23";
    public static final String SURROUND_SYSTEM = "1";
    public static final String PROVINCE_ID = "PROVINCE_ID";
    public static final String STATE_CITY = "state_city";
    public static final String OBJECT = "object";
    public static final String HEADER = "header";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String WARD = "ward";
    public static final String BANK_LIST = "bank_list";
    public static final String ADD_BENFICIARY = "add_ben";
    public static final String AIICO = "aiico";
    public static final String HOSPITAL_NAME = "hospital_name";
    public static final String STATE_NAME = "state_name";
    public static final String LGA_NAME = "lga_name";
    public static final String ILS = "ils";
    public static final String OFFER_LIST = "offer_list";
    public static final String PROVIDER_LIST = "provider_list";
    public static final String OFFER_AMOUNT = "offer_amount";
    public static final String PAYABLE_AMOUNT = "pay_amount";
    public static final String INTEREST = "interest";
    public static final String EXP_DATE = "exp_date";
    public static final String OFFER_ID = "offer_id";
    public static final String PROVIDER_ID = "provider_id";
    public static final String PROVIDER_NAME = "provider_name";
    public static final String OPEN_DASH = "dashoboard";
    public static final String CORNERSTONE_VEHICLE_INSURANCE = "8047";
    public static final String LENDIGO = "8057";
    public static final String TAG_MOBILE_TAB = "to mobile no.";
    public static final String TAG_RECEIVE_MONEY_TAB = "to Receive Money";
    public static final String TAG_REQUEST_TAB = "to Request Money";
    public static final String TAG_GENERATE_LINK_TAB = "Generate Payment Link";
    public static final String TAG_BANK_TAB = "to bank";
    public static final String TAG_QR_TAB = "to qr code";
    public static final String TAG_NFC_TAB = "pay by nfc";
    public static final String TAG_QR_TAB_MERCHANT = "qr code";
    public static final String TAG_MERCHANT_TAB = "SEARCH";
    public static final String OPEN_FROM = "open_from";
    public static final String OPEN_TYPE = "open_type";
    public static final String OPEN_AMOUNT = "amount";
    public static final String OPEN_MOBILE = "mobile";
    public static final String OPEN_CREDIT_TYPE = "credit_type";
    public static final String OPEN_FOR_MERCHANT_PIN = "open_for_merchant_pin";
    public static final String QR_SCAN_RESULT = "qr_scan_result";
    public static final String QR_CONTACT = "qr_code";
    public static final String QR_MONEY = "qr_money";
    public static final String QR_WHAT_TEXT = "qr_what_text";
    public static final String BUNDLE_DATA = "bundle_data";
    public static final String BILLER_ID = "biller_id";
    public static final String PLAN_NAME = "plan_name";
    public static final String OPERATOR_ID = "operator_id";
    public static final String MAP_DATA = "map_data";
    public static final String DIALOG_PROGRESS_TEXT = "dialog_progress_text";
    public static final String ROW_CLICK_FLAG = "row_click_flag";
    public static final String GENDER_MALE = "M";
    public static final String GENDER_MALE_P = "Male";
    public static final String GENDER_FEMALE = "F";
    public static final String GENDER_FEMALE_P = "Female";
    public static final String NOT_TO_SAY = "N";
    public static final String NA = "N/A";
    public static final String PROMO = "PROMO";
    public static final String BANK_NAME = "bank_name";
    public static final String BANK_NAME_EVENT = "bankName";
    public static final String BANK_ID = "bank_id";
    public static final String TERM_N_CONDITION = "term_n_condition";
    public static final String COUNTRY_CODE_NIGERIA = "234";
    public static final String START_SCAN = "start_scan";
    public static final long MAXIMUM_AMOUNT_CONSTRAINT = 50000;
    public static final long MAXIMUM_MTN_AMOUNT_CONSTRAINT = 100;
    public static final long MIN_TRANSACTION_LIMIT = 10;
    public static final String OPERATOR_CODE = "operator_code";
    public static final String DATA_PLAN = "data_plan";
    public static final String SELECT_OPERATOR = "Select Operator";
    public static final String NINE_MOBILE = "9mobile";
    public static final String AIRTEL = "Airtel";
    public static final String MTN = "Mtn";
    public static final String NINE_MOBILE_CODE = "0";
    public static final String SAVING_AC_TYPE_CODE = "1";
    public static final String CURRENT_AC_TYPE = "2";
    public static final String IS_IN_APP_NOTIFICATION = "is_in_app_notification";
    public static final String NIGERIA_CURRENCY_CODE = "NGN";
    public static final String NIGERIA_COUNTRY_CODE = "NG";
    public static final String NARRATION = "NOWNOWWALLETTOPUP";
    public static final String PROJECT_TYPE = "NOWNOW";
    public static final String DEVICE_TYPE = "Android";
    public static final String TXN_SUCCESS = "SUCCESS";
    public static final String TXN_FAILED = "FAILED";
    public static final String TXN_PROGRESS = "IN_PROGRESS";
    public static final String TXN_REVERSAL_SUCCESS = "REVERSAL_SUCCESS";
    public static final String TXN_INITIAL_ENTRY = "INITIAL_ENTRY";
    public static final String DATA = "data";
    public static final String GREEN_LOTTO_BILLER_ID = "8037";
    public static final String HEALTH_CONNECT_DEV = "8069";
    public static final String CORNERSTONE_HEALTH_INSURANCE_MONTHLY = "8054";
    public static final String HEALTH_CONNECT = "8060";
    public static final String BILLER_WAEC = "8028";//Operator id --> 4012

    public static int WAEC_PINS = 0;
    public static final String STATIC_INTERNATIONAL_RECHARGE_BILLER_ID_DEV = "8139";//for development server
    public static final String STATIC_INTERNATIONAL_RECHARGE_BILLER_ID = "8139"; //for production server
    public static final String COUPON_TRANSFER = "511";
    public static final String CORNERSTONE_HEALTH_INSURANCE_YEARLY = "8055";
    public static final String STAR_TIMES_OPERATOR_ID = "2001";
    public static final String DSTV_OPERATOR_ID = "2002";
    public static final String GOTV_OPERATOR_ID = "2003";
    public static final String IROKO_OPERATOR_ID = "2004";
    public static final String DAARSAT_OPERATOR_ID = "2005";
    public static final String INFINITY_OPERATOR_ID = "2006";
    public static final String TREND_TV_OPERATOR_ID = "2008";
    public static final String AFRICAN_OPERATOR_ID = "2009";
    public static final String CABLE_AFRICA_NETWORK_OPERATOR_ID = "2010";
    public static final String MONTAGE_OPERATOR_ID = "2011";
    public static final String CONSAT_OPERATOR_ID = "2012";
    public static final String KANO_PREPAID_ID = "7003";
    public static final String PORTHACOURT_PREPAID_ID = "7006";
    public static final String EKO_PREPAID_ID = "8038";
    public static final String EKO_POSTPAID_ID = "8039";
    public static final String AEDC_PREPAID_ID = "8046";
    public static final String AEDC_POSTPAID_ID = "8047";
    public static final String IBADAN_DISCO_PREPAID_ID = "8048";
    public static final String KADUNA_PREPAID_ID = "8049";
    public static final String KADUNA_POSTPAID_ID = "8050";
    public static final String JOS_DISCO_PREPAID_ID = "8052";
    public static final String EEDC_PREPAID_ID = "7005";
    public static final String EEDC_POSTPAID_ID = "7004";
    public static final String REMITA_OPERATOR_ID = "8050";
    public static final Double BLANK_VALUE = 0.0;
    public static final String NYSC_REMITA_BILLER_ID = "8085";
    public static final String NECO_REMITA_BILLER_ID = "8088";
    public static final String STATIC_REMITA_BILLER_ID = "8000";
    public static final String SELF_TOP_UP = "SELF_TOP_UP";
    public static final String CATEGORY = "300";
    public static final String SUBCATEGORYDATA = "303";
    public static  String REGION_ID = "01";

    public static int itemId = 0;
    /*
    These are static ID's for Remita operator services for dynamic view
    implementation , it's just for demo view please confirm with Lakshy sir,
    */
    public static final String JAMB_REMITA_BILLER_ID = "8084";
    public static final String WAEC_REMITA_BILLER_ID = "8087";
    public static final String NIMC_REMITA_BILLER_ID = "8086";
    public static final String ALREADY_USE_RRR_NUMBER = "23";
    public static final String DUPLICATE_REQUEST_RRR_NUMBER = "13";
    public static final String CONVERION_REQUEST_RRR_NUMBER = "1";
    /**/
    public static final String BETTING = "700";
    public static final String INSURANCE_CATEGORY = "500";
    public static final String AIICO_INSURANCE_SERVICE = "AIICO Multishield";
    public static final String AIICO_INSURANCE = "8059";//8086 dev biller
    public static final String AIICO_INSURANCE_HEALTH = "8062";//8071 dev biller
    public static final String AIICO_INSURANCE_HEALTH_BRONZE_ANNUAL = "8141";
    public static final String AIICO_INSURANCE_HEALTH_SILVER_ANNUAL = "8143";
    public static final String AIICO_INSURANCE_HEALTH_GOLD_ANNUAL = "8145";
    public static final String AIICO_INSURANCE_HEALTH_PLATINUM_ANNUAL = "8147";
    public static final String AIICO_MONTHLY = "9045";//8091 dev
    public static final String AIICO_MONTHLY_PROD = "9045";
    public static final String AIICO_ANNUAL = "9046";//8092
    public static final String AIICO_ANNUAL_PROD = "9046";
    public static final String SMS_SERVICE = "911";
    public static final String[] COUNTRY_CODES = new String[]{
            "234"//Nigeria
    };
    public static final HashMap<String, Integer> CountryApiCodes = new HashMap<>();
    public static final HashMap<String, String> operatorName = new HashMap<>();

    public static final String THIRD_PARTY_RECHRAGE = "THIRD_PARTY_RECHARGE";
    public static final String INTERNATION_TOP_UP = "10A1";
    public static final String CONSUMER_LEVEL_KYC_1 = "1690";
    public static final String CONSUMER_LEVEL_KYC_2 = "3953";
    public static final String CONSUMER_LEVEL_KYC_3 = "3954";
    private static final ArrayList<String> NDC = new ArrayList<>();
    public static String ILS_BILLER_ID = "9010";
    public static boolean IS_RECREATE_SCREEN_BY_BANLANCE_UPDATE = false;
    public static String RECHARGE_COUPON_TYPE = "4"; //coupon_type=4 (recharge)
    public static String PAYMENT_COUPON_TYPE = "5";    //coupon_type=5 (payment)
    public static int DEVICE_WIDTH;
    public static int DEVICE_HEIGHT;
    public static String CHIRSTMAS_CARD = "christmas_card";
    public static final String CORE_AUTH_KEY_US_PW = "apiClient:apiClientSecret";
    private static Toast sToast;
    public static String CHRISTMAS_DATA = "Christmas_data";
    public static String RECENT_CONTACT = "recent_contact";
    public static String CHANGE_OPERATOR = "change_operator";
    public static String BUY_AIRTIME = "airtime";
    public static String SEND_MONEY_TO_MOBILE = "send_money_to_mobile";
    public static String BUY_DATA = "buy data";
    public static String SELECTED_POSITION = "selected_position";
    public static final ArrayList<Config> dynamicValidation = new ArrayList<>();
    public static Toast getToast() {
        return sToast;
    }

    public static void setToast(Toast sToast) {
        C.sToast = sToast;
    }

    public static void init() {
        sToast = Toast.makeText(App.getInstance(), "", Toast.LENGTH_SHORT);
        DEVICE_WIDTH = DeviceUtils.getDeviceWidth();
        DEVICE_HEIGHT = DeviceUtils.getDeviceHeight();
        initCodes();
    }
    private static void initCodes() {
        if (CountryApiCodes.isEmpty()) {
            CountryApiCodes.put("SELECT OPERATOR", 0);
            CountryApiCodes.put("GLO", 1);
            CountryApiCodes.put("MTN", 2);
            CountryApiCodes.put("9MOBILE", 3);
            CountryApiCodes.put("AIRTEL", 4);

        }

        if (operatorName.isEmpty()) {
            operatorName.put("ANG", "Airtel");
            operatorName.put("MTN", "MTN");
            operatorName.put("ETS", "9mobile");
            operatorName.put("GLO", "GLO");
        }
    }

    public static String getDynamicValidationValue(String key) {
        if (dynamicValidation.size() > 0) {
            for (Config config : dynamicValidation) {
                if (config.getKey().equalsIgnoreCase(key)) {
                    return config.getValue();
                }
            }
        }
        return null;
    }
    public static int getApiCode(String key) {
        if (CountryApiCodes.containsKey(key.toUpperCase()))
            return CountryApiCodes.get(key.toUpperCase());
        return 0;
    }

    public static String getOperatorName(String key) {
        if (operatorName.containsKey(key.toUpperCase()))
            return operatorName.get(key.toUpperCase());
        return "Select operator";

    }



    public static int getInputTYpe(String mColumnType) {
        if (mColumnType == null)
            return 0;
        switch (mColumnType) {

            case "A":
            case "ALL":
            case "AN":
                return InputType.TYPE_CLASS_TEXT;
            case "D":
                return InputType.TYPE_CLASS_DATETIME;
            case "N":
                return InputType.TYPE_CLASS_NUMBER;
            default:
                return 0;
        }
    }


    public static boolean isValidAmount(String input1) {

        String regex = "[+-]?[0-9][0-9]*";
        Pattern p = Pattern.compile(regex);
        // Creates a matcher that will match input1 against regex
        Matcher m = p.matcher(input1);

        if (m.find() && m.group().equals(input1))
            return true;
        else
            return false;
    }



    public interface EXTRA {
        String OLD_PIN = "oldpin";
        public static final String IS_REQUESTED_FOR_MERCHANT = "is_merchant_req"; //Merchant Use Request
        public static final String IS_ADD_MONEY = "is_add_money_req"; //Merchant Use Request

        public static final String SEND_MONEY_TYPE = "send_money_type";
        public static final String REQUEST_MONEY_TYPE = "request_money_type";
    }

    public interface Payment {
        String PHONENO = "phone_no";
        String ECASHAMOUNT = "e_cash_amount";
        String OPERATOR = "operator";
        String RECHARGEAMOUNT = "recharge_amount";
        String PROMOCODE_STATE = "promocode_state";
        String PROMOCODE_VALUE = "promocode_value";
        String FINAL_VALUE = "final_value";
        String ECASH_BALANCE_STATE = "mEcashBalanceFlag";
        int CARD_IO_ACTIVITY_ID = 1008;
        int ONE_SECOND = 1000;
        int SCAN_CARD_TIME_OUT = 30 * ONE_SECOND;
    }

    public interface Via {
        int SEND_MONEY = 1;
        int SEND_MONEY_PIN = 2;
        int QR_SEND_MONEY_MOBILE = 3;
        int PAY_MERCHANT = 4;
        int MERCHANT_SELECTED = 5;
        int REQUEST_MONEY = 6;
        int GENERATE_QR = 7;
        int GENERATED_QR = 8;
        int SELECTED_BANK = 9;
        int SEND_MONEY_REGISTRATION = 10;
        int ADD_MONEY_PARENT = 11;
        int ADD_MONEY_BANK = 12;
        int ADD_MONEY_CASH = 13;
        int ADD_MONEY_PG_PIN = 63;
        int ADD_MONEY_ATM = 14;
        int ADD_MONEY_LOCATION = 15;
        int SERACH_MERCHANT_ADDMONEY = 16;
        int SERACH_MERCHANT_PAYMERCHANT = 17;
        int ADD_MONEY_MAPVIEW = 18;
        int SAVE_CARD_PROFILE = 19;
        int SAVE_CARD_PAYMENT = 20;
        int HAVING_PIN = 21;
        int WITHOUT_PIN = 22;
        int WITHDRAW_MONEY = 23;
        int SEND_MONEY_QR_MODE = 24;
        int SEND_MONEY_QR_MAPPING_CODE = 25;
        int BUY_DATA = 28;
        int SEND_MONEY_MOBILE = 26;
        int SEND_MONEY_BANK = 27;
        int REQUEST_MONEY_MOBILE = 31;
        int REQUEST_MONEY_LINK = 32;
        int REQUEST_MONEY_QR = 33;
        int BUY_AIRTIME = 29;
        int RECHARGE_TRANS = 59;
        int FORGOT = 71;

    }



    public interface DEEP_NAVIGATION {
        String CATEGORY_CODE = "categorycode";
        String ADD_MONEY = "add_money";
        String SEND_MONEY = "send_money";
        String RCV_MONEY = "receive_money";
        String BUY_DATA = "buy_data";
        String BUY_AIRTIME = "buy_airtime";
        String SEND_QR = "send_qr";
        String BILL_PAYMENT = "pay_bill";
        String BILLER_CODE = "billercode";
        String OPERATOR_CODE = "operatorcode";
        String SPLASH = "splash";
        String DELETE = "delete";
    }

    public interface DEEP_NAVIGATION_BY_CATEGORY {
        String IKEJA_PREPAID = "ikeja prepaid";
        String IKEJA_POSTPAID = "ikeja postpaid";
        String EKO_PREPAID = "eko prepaid";
        String EKO_POSTPAID = "eko postpaid";
        String AEDC_PREPAID = "aedc prepaid";
        String AEDC_POSTPAID = "aedc postpaid";
        String ENUGU_PREPAID = "enugu_prepaid";
        String ENUGU_POSTPAID = "enugu_postpaid";
        String IBADAN_DISCO_PREPAID = "ibadan disco prepaid";
        String IBADAN_DISCO_POSTPAID = "ibadan disco postpaid";
        String JOS_PREPAID_DISCO = "jos_prepaid_disco";
        String KADUNA_ELECTRICITY_DISCO_PREPAID = "kaduna_electricity_disco_prepaid";
        String KADUNA_ELECTRICITY_DISCO_POSTPAID = "kaduna_electricity_disco_postpaid";
        String PORTHARCOURT_PREPAID = "portharcourt prepaid";
    }

    public interface TransactionLimitKey {
        String CSIN = "CSIN";
        String AIRE = "AIRE";
        String SDRMT = "SDRMT";
        String ALLOC = "ALLOC";
        String AIRB = "AIRB";
        String AIRT = "AIRT";
        String ADMNY = "ADMNY";
        String CASH = "CASH";
        String W2B = "W2B";
        String BILL = "BILL";
        String AGNT = "AGNT";
        String LAPV = "LAPV";
        String LRQT = "LRQT";
    }

    public interface CMDS {
        int LOGN = 2;
    }

    public interface NetCore {
        String APP_ID = "95f6f253198fbf836a2badee5e78af79";

    }

    public interface FreshChat {
        String APP_ID = "9411819f-15f6-4086-b6c8-586dc5d9b754";
        String APP_KEY = "8a3b5f51-ef8d-4ac1-9da9-2b6522206a9d";
        String DOMAIN = "msdk.freshchat.com";
    }

    public interface SharedSecureKey {
        String SECURE_KEY = "eyJhbGciOiJub25lIn0.eyJzdWIiOiI3OTMyMTEyNDk5MTg0In0";

    }

    public interface Appsflyer {
        String API_KEY = "tWQoFUbna7RVEzBiSmbEii";
    }

    public interface BusinessEntites {
        String BUSINESS_ENTITY_TYPE = "business_entity_type";
        String BUSINESS_ENTITY_SUB_TYPE = "business_entity_sub_type";
        String BUSINESS_NAME = "business_name";
        String BUSINESS_ADDRESS = "business_address";
        String BUSINESS_STATE_ID = "business_state_id";
        String BUSINESS_CITY = "business_city";
        String BUSINESS_STREET = "business_street";
        String BUSINESS_LANDMARK = "business_landmark";
        String BUSINESS_REGISTERED = "business_registered";
        String BUSINESS_INDUSTRY = "business_industry";
        String BUSINESS_RC_NUMBER = "business_number";
        String BUSINESS_TYPE = "business_type";
        String BUSINESS_TERMS_ACCEPTED = "business_terms";
    }

    public interface DirectorsEntity {
        String DIRECTOR_MOBILE_SECOND = "director_mobile_second";
        String DIRECTOR_FIRST_NEAME_SECOND = "director_f_name_second";
        String DIRECTOR_LAST_NEAME_SECOND = "director_l_name_second";
        String DIRECTOR_DOB_SECOND = "director_dob_second";
    }


    public interface DynamicCheck {
        String KANO_PREPAID_MIN = "kano_prepaid_min";
        String KANO_PREPAID_MAX = "kano_prepaid_max";
        String EKO_PREPAID_MIN = "eko_prepaid_min";
        String EKO_PREPAID_MAX = "eko_prepaid_max";
        String EKO_POSTPAID_MIN = "eko_postpaid_min";
        String EKO_POSTPAID_MAX = "eko_postpaid_max";
        String AEDC_PREPAID_MIN = "aedc_prepaid_min";
        String AEDC_PREPAID_MAX = "aedc_prepaid_max";
        String SMS_CHARGES = "sms_charges";
        String AEDC_POSTPAID_MIN = "aedc_postpaid_min";
        String AEDC_POSTPAID_MAX = "aedc_postpaid_max";
        String IBADAN_DISCO_PREPAID_MIN = "ibadan_disco_prepaid_min";
        String IBADAN_DISCO_PREPAID_MAX = "ibadan_disco_prepaid_max";
        String JOS_DISCO_PREPAID_MIN = "jos_disco_prepaid_min";
        String JOS_DISCO_PREPAID_MAX = "jos_disco_prepaid_max";
        String KADUNA_PREPAID_MIN = "kaduna_prepaid_min";
        String KADUNA_PREPAID_MAX = "kaduna_prepaid_max";
        String KADUNA_POSTPAID_MIN = "kaduna_postpaid_min";
        String KADUNA_POSTPAID_MAX = "kaduna_postpaid_max";
        String PORTHACOURT_PREPAID_MIN = "porthacourt_prepaid_min";
        String PORTHACOURT_PREPAID_MAX = "porthacourt_prepaid_max";
        String AIRTEL_AIRTIME_MIN = "airtel_airtime_min";
        String MIN_TRANSACTION_LIMIT = "min_transaction_limit";
        String MAX_TRANSACTION_LIMIT = "max_transaction_limit";
        String PAY_BILL_TIMEOUT = "pay_bill_timeout";
        String QUERY_BILL_TIMEOUT = "query_bill_timeout";
        String NORMAL_TIMEOUT = "normal_timeout";
        String MAINTENANCE_MODE = "maintenanceMode";
        String UPDATED_VERSION = "updatedVersion";
        String FORCE_UPDATE_VERSION = "forceUpdateVersion";
        String ENTITY_TYPE = "entityType";
        String PAGE_SIZE = "pageSize";
        String DAYS_UNTILL_PROMPT_RATE_DIALOG = "days_untill_prompt_rate_dialog";
        String LAUNCH_COUNT_RATE_DIALOG = "launch_count_rate_dialog";
        String NOWNOW_MCASH_CODE = "nownow_mash_code";
        String EEDC_POSTPAID_MIN = "eedc_postpaid_min";
        String EEDC_POSTPAID_MAX = "eedc_postpaid_max";
        String EEDC_PREPAID_MIN = "eedc_prepaid_min";
        String EEDC_PREPAID_MAX = "eedc_prepaid_max";
        String COMING_SOON_LIST = "comingSoonList";
        String BETTING = "betting";
        String DEFAULT_ACCOUNT = "default_account";
        String TollFree_Number = "tollfreenumber_hc";
        String OPEN_BANNER_CLICK = "openBillersOnBannerClick";
        String DISABLE_W2W = "disableW2W";
        String APP_THEME = "app_theme";
        String HISTORY_CHAT_OPTION = "history_chat_option";
        String APP_THEME_COLOR = "app_theme_color";
        String DASKBOARD_TOP_DESIGN_ONE = "dashboard_top_design-1";
        String DASKBOARD_TOP_DESIGN_TWO = "dashboard_top_design-2";
        String DASKBOARD_BOTTOM_DESIGN_ONE = "dashboard_bottom_design-1";
        String DASKBOARD_BOTTOM_DESIGN_TWO = "dashboard_bottom_design-2";
        String APP_THEME_LOGO = "app_theme_logo";
        String APP_THEME_SIDE_ICON = "app_theme_side_icon";
        String APP_THEME_BILLER_BG = "app_theme_biller_bg";

        String CATEGORY_100 = "category_100";
        String CATEGORY_1700 = "category_1700";
        String SELECT_OPERATOR = "select_operator";
        String CUSTOMER_NAME = "customer_Name";
        String CUSTOMER_KEY = "customer_Key";
    }

    public interface SMILEID {
        String EXTRA_ENROLL_MODE = "EXTRA_ENROLL_MODE";
        String EXTRA_HAS_ID = "EXTRA_HAS_ID";
        String EXTRA_REENROLL = "EXTRA_REENROLL";
        String EXTRA_ENROLL_TYPE = "EXTRA_ENROLL_TYPE";
        String EXTRA_ENROLL_TAG_LIST = "EXTRA_ENROLL_TAG_LIST";

    }

    public interface CustomViewValidation {
        String COLUMNTYPE_A = "A";
        String COLUMNTYPE_N = "N";
        String COLUMNTYPE_AN = "AN";
        String COLUMNTYPE_D = "D";
        String COLUMNTYPE_ALL = "ALL";
        String COLUMNTYPE_DD = "DD";
        String COLUMNTYPE_SL = "SL";
        String COLUMNTYPE_SP = "SP";
    }

    public interface TransactionType {
        String DR = "DR";
        String CR = "CR";
    }


    public static class REMITA {
        public static final String PUBLIC_KEY = "U1lTUHwyNTQ3OTE2fDhmOTYzNDBjY2UxYTMzZWVlNDM2M2Y0MGZhMDRmZGQxOGQ3ZjQ1ZDlhZTg1ZTA2ZWExODAwOGZjN2Q0NDg0ZTQ1NDdjZjRhNzcwZTEyNGI0MzYyYTgzODc0NjlmM2NkYWIxYmQ4YzFiZjljNzAxNGY1MWE1ZjNjMGE5NGIyODFm";
        public static final String TRANACTION_ID = "427e3b83-faaa-4c4d-a493-3063e7974344";
    }
}