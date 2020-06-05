public class person {
	int uyeNo_lbl;
	String cinsiyet_lbl;
	String ad_lbl;
	String soyad_lbl;
	String calismayer_lbl;
	String mail_lbl;
	long kimlikNo_lbl;
	String mezTarihi_lbl;
	String bolum_lbl;
	long tel_lbl;
	String adres_lbl;
	String il_lbl;
	String girisTarihi_lbl;
	String uyeDurumu_lbl;
	int[] borcarray;
	int[] aidatarray;
	
	public int[] getBorcarray() {
		return borcarray;
	}
	public void setBorcarray(int[] borcarray) {
		this.borcarray = borcarray;
	}
	public int[] getAidatcarray() {
		return aidatarray;
	}
	public void setAidatarray(int[] aidatarray) {
		this.aidatarray = borcarray;
	}
	public int getUyeNo_lbl() {
		return uyeNo_lbl;
	}
	public void setUyeNo_lbl(int uyeNo_lbl) {
		this.uyeNo_lbl = uyeNo_lbl;
	}
	public long getKimlikNo_lbl() {
		return kimlikNo_lbl;
	}
	public void setKimlikNo_lbl(int kimlikNo_lbl) {
		this.kimlikNo_lbl = kimlikNo_lbl;
	}
	public String getSoy_lbl() {
		return soyad_lbl;
	}
	public void setSoy_lbl(String soyad_lbl) {
		this.soyad_lbl = soyad_lbl;
	}
	public String getAd_lbl() {
		return ad_lbl;
	}
	public void setAd_lbl(String ad_lbl) {
		this.ad_lbl = ad_lbl;
	}
	public String getCinsiyet_lbl() {
		return cinsiyet_lbl;
	}
	public void setCinsiyet_lbl(String cinsiyet_lbl) {
		this.cinsiyet_lbl = cinsiyet_lbl;
	}
	public String getBolum_lbl() {
		return bolum_lbl;
	}
	public void setBolum_lbl(String bolum_lbl) {
		this.bolum_lbl = bolum_lbl;
	}
	public String getCalismayer_lbl() {
		return calismayer_lbl;
	}
	public void setCalismayer_lbl(String calismayer_lbl) {
		this.calismayer_lbl = calismayer_lbl;
	}
	public String getMail_lbl() {
		return mail_lbl;
	}
	public void setMail_lbl(String mail_lbl) {
		this.mail_lbl = mail_lbl;
	}
	public long getTel_lbl() {
		return tel_lbl;
	}
	public void setTel_lbl(long tel_lbl) {
		this.tel_lbl = tel_lbl;
	}
	public String getAdres_lbl() {
		return adres_lbl;
	}
	public void setAdres_lbl(String adres_lbl) {
		this.adres_lbl = adres_lbl;
	}
	public String getIl_lbl() {
		return il_lbl;
	}
	public void setIl_lbl(String il_lbl) {
		this.il_lbl = il_lbl;
	}
	public String getMezTarihi_lbl() {
		return mezTarihi_lbl;
	}
	public void setMezTarihi_lbl(String mezTarihi_lbl) {
		this.mezTarihi_lbl = mezTarihi_lbl;
	}
	public String getGirisTarihi_lbl() {
		return girisTarihi_lbl;
	}
	public void setGirisTarihi_lbl(String girisTarihi_lbl) {
		this.girisTarihi_lbl = girisTarihi_lbl;
	}
	public String getUyeDurumu_lbl() {
		return uyeDurumu_lbl;
	}
	public void setUyeDurumu_lbl(String uyeDurumu_lbl) {
		this.uyeDurumu_lbl = uyeDurumu_lbl;
	}
	
	
	person() {
		this.uyeNo_lbl = 0;
		this.kimlikNo_lbl = 0;
		this.ad_lbl = "Bilinmiyor";
		this.soyad_lbl = "Bilinmiyor";
		this.cinsiyet_lbl = "Bilinmiyor";
		this.bolum_lbl = "Bilinmiyor";
		this.calismayer_lbl = "Bilinmiyor";
		this.mail_lbl = "Bilinmiyor";
		this.tel_lbl = 0;
		this.adres_lbl = "Bilinmiyor";
		this.il_lbl = "Bilinmiyor";
		this.mezTarihi_lbl = "Bilinmiyor";
		this.girisTarihi_lbl = "Bilinmiyor";
		this.uyeDurumu_lbl = "Bilinmiyor";
		this.borcarray= null;
		this.aidatarray = null;
		
	}
	person(int uyeNo, String cinsiyet,String ad, String soyad,String calismayer, String mail, long kimlikNo,
			String mezTarihi,String bolum, long tel,String adres,String il,int[] aidatarr, int[] borcarr, 
			String uyeDurumu, String girisTarihi) {
		this.uyeNo_lbl = uyeNo;
		this.kimlikNo_lbl = kimlikNo;
		this.ad_lbl = ad;
		this.soyad_lbl = soyad;
		this.cinsiyet_lbl = cinsiyet;
		this.bolum_lbl = bolum;
		this.calismayer_lbl = calismayer;
		this.mail_lbl = mail;
		this.tel_lbl = tel;
		this.adres_lbl = adres;
		this.il_lbl = il;
		this.mezTarihi_lbl = mezTarihi;
		this.girisTarihi_lbl = girisTarihi;
		this.uyeDurumu_lbl = uyeDurumu;
		this.borcarray= borcarr;
		this.aidatarray = aidatarr;
		
	}
}
