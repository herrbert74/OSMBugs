package org.gittner.osmbugs.statics;

import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Settings {
	
	private static SharedPreferences prefs_;
	
	public static void init(Context context) {
		prefs_ = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public static boolean getCenterGps() {
		return prefs_.getBoolean("pref_center_gps", true);
	}
	
	public static void setCenterGps(boolean state) {
		prefs_.edit().putBoolean("pref_center_gps", state).commit();
	}
	
	public static boolean isLanguageGerman() {
		if(Locale.getDefault().getISO3Language().equals("deu"))
			return true;
		
		return false;
	}

	public static class Keepright {
		
		public static boolean isEnabled() {
			return prefs_.getBoolean("pref_keepright_enabled", true);
		}
		
		public static boolean is20Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_20", false);
		}

		public static boolean is30Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_30", true);
		}

		public static boolean is40Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_40", true);
		}

		public static boolean is50Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_50", true);
		}

		public static boolean is60Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_60", false);
		}

		public static boolean is70Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_70", true);
		}

		public static boolean is90Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_90", true);
		}

		public static boolean is100Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_100", true);
		}

		public static boolean is110Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_110", true);
		}

		public static boolean is120Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_120", true);
		}

		public static boolean is130Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_130", true);
		}

		public static boolean is150Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_150", true);
		}

		public static boolean is160Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_160", true);
		}

		public static boolean is170Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_170", true);
		}

		public static boolean is180Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_180", true);
		}

		public static boolean is190Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_190", true);
		}

		public static boolean is200Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_200", true);
		}

		public static boolean is210Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_210", true);
		}

		public static boolean is220Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_220", true);
		}

		public static boolean is230Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_230", true);
		}

		public static boolean is270Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_270", true);
		}

		public static boolean is280Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_280", true);
		}

		public static boolean is290Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_290", true);
		}

		public static boolean is300Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_300", false);
		}

		public static boolean is310Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_310", true);
		}

		public static boolean is320Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_320", true);
		}

		public static boolean is350Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_350", true);
		}

		public static boolean is360Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_360", false);
		}

		public static boolean is370Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_370", true);
		}

		public static boolean is380Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_380", true);
		}

		public static boolean is390Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_390", false);
		}

		public static boolean is400Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_400", true);
		}

		public static boolean is410Enabled() {
			return prefs_.getBoolean("pref_keepright_enabled_410", true);
		}

		public static boolean isShowTempIgnoredEnabled() {
			return prefs_.getBoolean("pref_keepright_enabled_show_tmpign", true);
		}

		public static boolean isShowIgnoredEnabled() {
			return prefs_.getBoolean("pref_keepright_enabled_show_ign", true);
		}
	}
	
	public static class Openstreetbugs {
		
		public static boolean isEnabled() {
			return prefs_.getBoolean("pref_openstreetbugs_enabled", true);
		}
		
		public static boolean isShowOnlyOpenEnabled() {
			return prefs_.getBoolean("pref_openstreetbugs_enabled_only_open", true);
		}

		public static int getBugLimit() {
			return Integer.parseInt(prefs_.getString("pref_openstreetbugs_bug_limit", "1000"));
		}
		
		public static String getUsername() {
			return prefs_.getString("pref_openstreetbugs_username", "John Doe");
		}		
	}
	
	public static class Mapdust {
		
		public static boolean isEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled", true);
		}

		public static boolean isShowOpenEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_open", true);
		}

		public static boolean isShowClosedEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_closed", true);
		}

		public static boolean isShowIgnoredEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_ignored", true);
		}

		public static boolean isWrongTurnEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_wrong_turn", true);
		}

		public static boolean isBadRoutingenabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_bad_routing", false);
		}

		public static boolean isOnewayRoadEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_oneway_road", true);
		}

		public static boolean isBlockedStreetEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_blocked_street", true);
		}

		public static boolean isMissingStreetEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_missing_street", true);
		}

		public static boolean isRoundaboutIssueEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_roundabout_issue", true);
		}

		public static boolean isMissingSpeedInfoEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_missing_speed_info", true);
		}

		public static boolean isOtherEnabled() {
			return prefs_.getBoolean("pref_mapdust_enabled_other", true);
		}
	}
	
	public static class OpenstreetmapNotes{
		
		public static boolean isEnabled() {
			return prefs_.getBoolean("pref_openstreetmap_notes_enabled", true);
		}
		
		public static boolean isShowOnlyOpenEnabled() {
			return prefs_.getBoolean("pref_openstreetmap_notes_enabled_only_open", true);
		}

		public static int getBugLimit() {
			return Integer.parseInt(prefs_.getString("pref_openstreetmap_notes_note_limit", "1000"));
		}
	}
}
