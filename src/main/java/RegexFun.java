package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexFun {
	public void tokenizer(String longString) {

		/*
		 * Pattern p3 = Pattern.compile("(?i)^" + HOW_MUCH + "(\\sis\\s){1}(\\D+)(\\s\\\\?){1}");
		 * 
		 * List<String> howMuchIsList = new ArrayList<String>(); int lineCounter3 = 0; for (String
		 * inputLine : intergalacticInputLines) { Matcher matcher = p3.matcher(inputLine); while
		 * (matcher.find()) { String amount = matcher.group(2); howMuchIsList.add(amount); // to
		 * keep track of processed lines successMap.put(lineCounter3, true); } lineCounter3++; }
		 */
		if (longString.length() > 400000) {
			return;
		}
		// String regex = "\\W+";
		String regex = "[^A-Za-z0-9]+";
		String[] array = longString.split(regex);

		System.out.println(array.length);
		for (String word : array) {
			System.out.println(word);
		}
	}

	public void testTokenizer() {

		String str = "He is a very very good boy, isn't he?";
		tokenizer(str);

		String longStr = "Good luck with this case!!! h jrkjc c l m e i vct h ss pqk_v i olf tuoej_          p r jrpjpuo a.          udc mu tk g dc,          j o mui brljn!jv p rsklqu p?a lv l n dl quo!cml pld qf l s!          t nb ud j etc q           a j f ugc eer c,          ci de lm p iwk_nwa e su s u ga.l w xlkod f e v_          oo ukaa v t xe.          j cl vmh hi tl!          xa aw ugeibo?c r oo v qte ri,          elbf ibg qk i_m nm s ainis s           u m rhd fgi h v!          mji tu oj t c d.x hxtp a bf xj.          l j ela wuj is           pj gu fs e o v i,s s i b k kab tw@          im c vlud k ki!          e ft gpcf t g k'          m c r snv w b rw,hwoh dfl hn u@cb ep ucsse j_          a d h q p w q rjp_          tln j vofvwg_sj rx pur l dx_          vo b lk sljnm?          k xox i cv va l,          du toe sdwx g@c s uded gw od!          tqsv v t v fnl'          o amka ll x s q_          a frs s ltubs?wdjfdrf x jk.jgkb d s d k n m@sedwkpe ev h_icr ggqxvap@          j g hva o kja q?          j j q ra iak c u!          vqnf thfw wx!          ccn mox sp do'u r ei ifah nl'u g m qipu r c e           ws op hng fbp.          fr vle qh d fv_okcei p e oal_a nsxi g to w x!          qfvv sr cjmo_          kchrkonuc f'ush wd xptas!rfrt o llgwf?          jclpl wmt h r           rv o lhnxnbf           h fqfnla pft?n b uu tbba sl_u ij f i jox xu.ext p gs un dc           fx p o kh rl l j'nkgevg xdrq?          q s wv umu olw?jaidu ilpr e?fc qcr p htpn           g xt d d uqk cp,          cts jkg e i op_j utt rf gvm t!          qgjr r r s cpc,          m n a wde pcg v?e ioek nlc fh@ahk ei ejmp d_fq enmeoesu?          skntwnolsx!j bt bgb dhtt!          r jcl mdh i kr,          m jcl fgix gq_enpuk n g rl i?ei xedl o h e a!x wjp uge h w g'wb dg wlkxli qi x ff eq gbe_bakb m c p aos_vv c m labuj r!          s t oign xwn a@c ffwpic wck_          gmkahnse si!q viev a ndfg,f p utcumoxb'          kgd m n g gnk b!          i rr x x uxx g p_          af s piu hgs o?          kpmrltmrqe@s m mbjfnxq p'          g f i v l wc u ij@";
		tokenizer(longStr);

		String str2 = "Good luck with this case!!! (bad) umbrella ";
		tokenizer(str2);
	}

	public void patternCheck(String patternString) {
		try {
			Pattern p = Pattern.compile(patternString);
			System.out.println("Valid");
		} catch (PatternSyntaxException pse) {
			System.out.println("Invalid");
		}
	}

	public void testIsIpAddress() {

		List<String> ipsToCheck = Arrays.asList("255.", "188.", "255.124.134.", "255.12.42.",
				"123.12.9.", "9.9.9.", "0.9.9.", "255.99.199.9", "206.217.228.239",
				"123.123.125.234", "000.12.12.034", "121.234.12.12", "23.45.12.56",
				"000.12.234.23.23", "666.666.23.23", ".213.123.23.32", "23.45.22.32.",
				"I.Am.not.an.ip", "000.12.12.034", "121.234.12.12", "23.45.12.56",
				"00.12.123.123123.123", "122.23", "Hello.IP");
		// IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range
		// from 0 to 255.
		// Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
		String ipRegex = new MyRegex().pattern;
		Pattern p = Pattern.compile(ipRegex);

		for (String ip : ipsToCheck) {
			Matcher m = p.matcher(ip);
			if (m.matches()) {
				System.out.println("true:" + ip);

			} else {
				System.out.println("false:" + ip);
			}
		}

	}

	public void testTrimAccountName() {
		//String originalPreferredName = "Very long account name because that is what it is - 3498";
		String originalPreferredName = "Bofa Regular Checking - 5669";

		Pattern MY_PATTERN = Pattern.compile("(.{54})(.*)?(-\\s+\\d{4}$)");
		Matcher m = MY_PATTERN.matcher("Very long account name because that is what it is - 3498");
		while (m.find()) {
			String s = m.group(0);
			String s2 = m.group(1);
			String s3 = m.group(3);
			System.out.println(s + "[" +s2+ "]" +"[" +s3+ "]" );
			// s now contains "BAR"
		}

		int maxLength = 50;

		if (originalPreferredName.length() > maxLength) {
			// accountDigits = accountName1.substring(accountName1.length()-5,
			// accountName1.length()-1);

			String ellipses = "\u2026";
			int accountPostFixPosition = originalPreferredName.lastIndexOf('-');
			String accountPostFix = originalPreferredName.substring(accountPostFixPosition); //6 characters  [- xyzd]

			System.out.println(accountPostFix);
			String trimmedAccountNickName = originalPreferredName.substring(0, maxLength
					- accountPostFix.length() - 2).trim()
					+ "\u2026" + " "+ accountPostFix;
			System.out.println(trimmedAccountNickName);
			System.out.println("Number of characters: " + trimmedAccountNickName.length());

		}else {
			System.out.println(originalPreferredName);
			System.out.println("Number of characters: " + originalPreferredName.length());

		}

	}

	class MyRegex2 {
		String account4Digits = "\\d[4]";
		String patter = "";
	}

	class MyRegex {
		// String pattern = "((2[0-5][0-5]|[01]?\\d{1,2})\\.){3}(2[0-5][0-5]|[01]?\\d{1,2})";
		// String pattern =
		// "((2[0-5]{2}|2[0-4]\\d|[01]?\\d{1,2})\\.){3}(2[0-5]{2}|2[0-4]\\d|[01]?\\d{1,2})";

		String subPart = "(2[0-5]{2}|2[0-4]\\d|[01]?\\d{1,2})";
		String pattern = "(" + subPart + "\\.){3}" + subPart;
	}

}
