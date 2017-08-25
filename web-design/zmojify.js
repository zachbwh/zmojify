
currentLanguage = ["en", "English"]


languages = [
  ["af", "Afrikaans"],
  ["am", "Amharic"],
  ["ar", "Arabic"],
  ["as", "Assamese"],
  ["az", "Azerbaijani"],
  ["be", "Belarusian"],
  ["bg", "Bulgarian"],
  ["bn", "Bangla"],
  ["bs", "Bosnian"],
  ["ca", "Catalan"],
  ["cs", "Czech"],
  ["cy", "Welsh"],
  ["da", "Danish"],
  ["de", "German"],
  ["el", "Greek"],
  ["en", "English"],
  ["es", "Spanish"],
  ["et", "Estonian"],
  ["eu", "Basque"],
  ["fa", "Persian"],
  ["fi", "Finnish"],
  ["fil", "Filipino"],
  ["fr", "French"],
  ["ga", "Irish"],
  ["gl", "Galician"],
  ["gu", "Gujarati"],
  ["he", "Hebrew"],
  ["hr", "Croatian"],
  ["hu", "Hungarian"],
  ["hy", "Armenian"],
  ["id", "Indonesian"],
  ["is", "Icelandic"],
  ["it", "Italian"],
  ["ja", "Japanese"],
  ["ka", "Georgian"],
  ["kk", "Kazakh"],
  ["km", "Khmer"],
  ["kn", "Kannada"],
  ["ko", "Korean"],
  ["ky", "Kyrgyz"],
  ["lo", "Lao"],
  ["lt", "Lithuanian"],
  ["lv", "Latvian"],
  ["mk", "Macedonian"],
  ["ml", "Malayalam"],
  ["mn", "Mongolian"],
  ["mr", "Marathi"],
  ["ms", "Malay"],
  ["my", "Burmese"],
  ["nb", "Norwegian Bokmål"],
  ["ne", "Nepali"],
  ["nl", "Dutch"],
  ["or", "Odia"],
  ["pa", "Punjabi"],
  ["pl", "Polish"],
  ["pt", "Portuguese"],
  ["ro", "Romanian"],
  ["ru", "Russian"],
  ["si", "Sinhala"],
  ["sk", "Slovak"],
  ["sl", "Slovenian"],
  ["sq", "Albanian"],
  ["sr", "Serbian"],
  ["sv", "Swedish"],
  ["sw", "Swahili"],
  ["ta", "Tamil"],
  ["te", "Telugu"],
  ["th", "Thai"],
  ["tr", "Turkish"],
  ["uk", "Ukrainian"],
  ["ur", "Urdu"],
  ["uz", "Uzbek"],
  ["vi", "Vietnamese"],
  ["zh", "Chinese"],
  ["zu", "Zulu"],
]

function getLanguageIndex(languageCode) {
  for (i = 0; i < languages.length; i++) {
    if (languageCode == languages[i][0]) {
      return i;
    }
  }
}

function getLanguageData(languageIndex) {
  var languageRequest = new XMLHttpRequest();
  languageRequest.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      parser = new DOMParser();
      var languageData = parser.parseFromString(this.responseText,"text/xml");
      languages[languageIndex][2] = languageData;
      currentLanguage[2] = languageData;
    }
  }
  languageRequest.open("GET", "http://zmojify.io/languages/" + languages[languageIndex][0] + ".xml", true);
  languageRequest.setRequestHeader("Access-Control-Allow-Origin", "http://www.unicode.org/")
  //languageRequest.withCredentials = true;
  languageRequest.send();
}

function query (search, language) {

}
