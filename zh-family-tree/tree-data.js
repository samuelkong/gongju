function addPerson(id, cn, pinyin, hk, jyutping, en, description) {
	people[id] = {
		en: en,
		cn: cn,
		pinyin: pinyin,
		hk: hk,
		jyutping: jyutping,
		description: description,
		relationships: []
	};
}

function addRelationship(person1, relationship, person2) {
	people[person1].relationships[relationship] = people[person2];
}

var people = [];

addPerson("ayi", "阿姨", "āyí", "阿姨", "aa3 ji4", "Aunt", "Mother's younger sister");
addPerson("baba", "爸爸", "bàba", "爸爸", "baa1 baa1", "Father", "Father");
addPerson("biaodi", "表弟", "biǎodì", "表弟", "biu2 dai6", "Cousin", "Son of mother's sibling (older)");
addPerson("biaoge", "表哥", "biǎogē", "表哥", "biu2 go1", "Cousin", "Son of mother's sibling (younger)");
addPerson("biaojie", "表姐", "biǎojiě", "表姐", "biu2 ze2", "Cousin", "Daughter of mother's sibling (younger)");
addPerson("biaomei", "表妹", "biǎomèi", "表妹", "biu2 mui6", "Cousin", "Daughter of mother's sibling (older)");
addPerson("biaozhinu", "表姪女 ", "biǎozhínǚ", "表姪女 ", "biu2 zat6 neoi5", "First cousin once removed", "Father's sister's son's daughter");
addPerson("biaozhizi", "表姪子", "biǎozhízi", "表姪子", "biu2 zat6 zi2", "First cousin once removed", "Father's sister's son's son");
addPerson("bofu", "伯父", "bófù", "伯父", "baak3 fu6", "Uncle", "Father's older brother");
addPerson("boniang", "伯娘", "bóniáng", "伯娘", "baak3 noeng4", "Aunt-in-law", "Father's older brother's wife");
addPerson("chongwaisunnu", "重外孙女", "chóngwàisūnnǚ", "重外孫女", "cung4 ngoi6 syun1 neoi5", "Great-granddaughter", "Daughter's daughter's daughter");
addPerson("chongwaisunzi", "重外孙子", "chóngwàisūnzi", "重外孫子", "cung4 ngoi6 syun1 zi2", "Great-grandson", "Daughter's daughter's son");
addPerson("dabo", "大伯", "dàbó", "大舅", "daai6 kau5", "Brother-in-law", "Husband's older brother");
addPerson("dagu", "大姑", "dàgū", "姑奶", "gu1 naai4", "Sister-in-law", "Husband's older sister");
addPerson("dajiu", "大舅", "dàjiù", "大伯", "daai6 baak3", "Brother-in-law", "Wife's older brother");
addPerson("dayi", "大姨", "dàyí", "大姨", "daai6 ji1", "Sister-in-law", "Wife's older sister");
addPerson("didi", "弟弟", "dìdì", "細佬", "sai3 lou2", "Brother", "Younger brother");
addPerson("difu", "弟妇", "dìfù", "弟媳", "dai6 sik1", "Sister-in-law", "Younger brother's wife");
addPerson("erzi", "儿子", "érzi", "仔", "zai2", "Son", "Son");
addPerson("gege", "哥哥", "gēgē", "大佬", "daai6 lou2", "Brother", "Older brother");
addPerson("gonggong", "公公", "gōnggōng", "老爺", "lou5 je2", "Father-in-law", "Husband's father");
addPerson("gubiaodi", "姑表弟", "gūbiǎodì", "表弟", "biu2 dai6", "Cousin", "Son of father's sister (younger)");
addPerson("gubiaoge", "姑表哥", "gūbiǎogē", "表哥", "biu2 go1", "Cousin", "Son of father's sister (older)");
addPerson("gubiaojie", "姑表姐", "gūbiǎojiě", "表姐", "biu2 ze2", "Cousin", "Daughter of father's sister (younger)");
addPerson("gubiaomei", "姑表妹", "gūbiǎomèi", "表妹", "biu2 mui6", "Cousin", "Daughter of father's sister (older)");
addPerson("gubiaosao", "姑表嫂", "gūbiǎosǎo", "表嫂", "biu2 sou2", "Cousin-in-law", "Father's sister's wife");
addPerson("gugu", "姑姑", "gūgū", "姑姐", "gu1 ze1", "Aunt", "Father's younger sister");
addPerson("guma", "姑妈", "gūmā", "姑媽", "gu1 maa1", "Aunt", "Father's older sister");
addPerson("guzhang", "姑丈", "gūzhàng", "姑丈", "gu1 zoeng6", "Uncle-in-law", "Father's sister's husband");
addPerson("jiefu", "姐夫", "jiěfū", "姐夫", "ze2 fu1", "Brother-in-law", "Older sister's husband");
addPerson("jiejie", "姐姐", "jiějiě", "家姐", "gaa1 ze1", "Sister", "Older sister");
addPerson("jiujiu", "舅舅", "jiùjiu", "舅父", "kau5 fu2", "Uncle", "Maternal uncle");
addPerson("jiuma", "舅妈", "jiùmā", "舅母", "kau5 mou5", "Aunt-in-law", "Maternal uncle's wife");
addPerson("laogong", "老公", "lǎogōng", "老公", "lou5 gung1", "Husband", "Husband");
addPerson("laopo", "老婆", "lǎopó", "老婆", "lou5 po4", "Wife", "Wife");
addPerson("mama", "妈妈", "māmā", "媽媽", "maa1 maa1", "Mother", "Mother");
addPerson("meifu", "妹夫", "mèifū", "妹夫", "mui6 fu1", "Brother-in-law", "Younger sister's husband");
addPerson("meimei", "妹妹", "mèimei", "細妹", "sai3 mui2", "Sister", "Younger sister");
addPerson("nainai", "奶奶", "nǎinai", "嫲嫲", "maa4 maa4", "Grandma", "Paternal gradmother");
addPerson("nuer", "女儿", "nǚér", "女兒", "neoi5 ji4", "Daughter", "Daughter");
addPerson("nuxu", "女婿", "nǚxù", "女婿", "neoi5 sai3", "Son-in-law", "Daughter's husband");
addPerson("popo", "婆婆", "pópo", "奶奶", "naai4 naai2", "Mother-in-law", "Husband's mother");
addPerson("saozi", "嫂子", "sǎozi", "阿嫂", "aa3 sou2", "Sister-in-law", "Older brother's wife");
addPerson("shenshen", "婶婶", "shěnshen", "阿嬸", "aa3 sam2", "Aunt-in-law", "Father's younger brother's wife");
addPerson("shushu", "叔叔", "shūshu", "阿叔", "aa3 suk1", "Uncle", "Father's younger brother");
addPerson("sunnu", "孙女", "sūnnǚ", "孫女", "syun1 neoi5", "Granddaughter", "Son's daughter");
addPerson("sunnuxu", "孙女婿", "sūnnǚxù", "孫女婿", "syun1 neoi5 sai3", "Grandson-in-law", "Son's daughter's husband");
addPerson("sunxifu", "孙媳妇", "sūnxífù", "孫新抱", "syun1 san1 pou5", "Granddaughter-in-law", "Son's son's wife");
addPerson("sunzi", "孙子", "sūnzi", "孫仔", "syun1 zai2", "Grandson", "Son's son");
addPerson("taigong", "太公", "tàigōng", "太公", "taai3 gung1", "Great-grandfather", "Maternal grandfather's father");
addPerson("taima", "太嫲", "tàima", "太嫲", "taai3 maa4", "Great-grandmother", "Paternal grandfather's mother");
addPerson("taipo", "太婆", "tàipó", "太婆", "taai3 po2", "Great-grandmother", "Maternal grandfather's mother");
addPerson("taiye", "太爷", "tàiyé", "太爺", "taai3 je4", "Great-grandfather", "Paternal grandfather's father");
addPerson("tangdi", "堂弟", "tángdì", "堂弟", "tong4 dai6", "Cousin", "Son of father's brother (younger)");
addPerson("tangjie", "堂姐", "tángjiě", "堂姐", "tong4 ze2", "Cousin", "Daughter of father's brother (older)");
addPerson("tangmei", "堂妹", "tángmèi", "堂妹", "tong4 mui2", "Cousin", "Daughter of father's brother (younger)");
addPerson("tangsao", "堂嫂", "tángsǎo", "堂嫂", "tong4 sou2", "Cousin-in-law", "Son of father's brother (older)'s wife");
addPerson("tangxiong", "堂兄", "tángxiōng", "堂哥", "tong4 go1", "Cousin", "Son of father's brother (older)");
addPerson("tangzhinu", "堂姪女 ", "tángzhínǚ", "堂姪女 ", "tong4 zat6 neoi5", "First cousin once removed", "Father's brother's son's daughter");
addPerson("tangzhizi", "堂姪子", "tángzhízi", "堂姪子", "tong4 zat6 zi2", "First cousin once removed", "Father's brother's son's son");
addPerson("waigong", "外公", "wàigōng", "公公", "gung1 gung1", "Grandpa", "Maternal grandfather");
addPerson("waipo", "外婆", "wàipó", "婆婆", "po4 po2", "Grandma", "Maternal grandmother");
addPerson("waisheng", "外甥", "wàishēng", "外甥", "ngoi6 sang1", "Nephew", "Sister's son (male)");
addPerson("waishengnu", "外甥女", "wàishēngnǚ", "外甥女", "ngoi6 sang1 neoi5", "Niece", "Sister's daughter (male)");
addPerson("waisunnu", "外孙女", "wàisūnnǚ", "外孫女", "ngoi6 syun1 neoi5", "Granddaughter", "Daughter's daughter");
addPerson("waisunnuxu", "外孙女婿", "wàisūnnǚxù", "外孫女婿", "ngoi6 syun1 neoi5 sai3", "Grandson-in-law", "Daughter's daughter's husband");
addPerson("waisunxifu", "外孙媳妇", "wàisūnxífù", "外孫媳婦", "ngoi6 syun1 sik1 fu5", "Granddaughter-in-law", "Daughter's son's wife");
addPerson("waisunzi", "外孙子", "wàisūnzi", "外孫", "ngoi6 syun1", "Grandson", "Daughter's son");
addPerson("waizengsunnu", "外曾孙女", "wàizēngsūnnǚ", "外曾孫女", "ngoi6 zang1 syun1 neoi5", "Great-granddaughter", "Daughter's son's daughter");
addPerson("waizengsunzi", "外曾孙子", "wàizēngsūnzi", "外曾孫子", "ngoi6 zang1 syun1 zi2", "Great-grandson", "Daughter's son's son");
addPerson("wo", "我", "wǒ", "我", "ngo5", "Me", "Me");
addPerson("xiaogu", "小姑", "xiǎogū", "姑仔", "gu1 zai2", "Sister-in-law", "Husband's younger sister");
addPerson("xiaojiu", "小舅", "xiǎojiù", "叔仔", "suk1 zai2", "Brother-in-law", "Wife's younger brother");
addPerson("xiaoshu", "小叔", "xiǎoshū", "舅仔", "kau5 zai2", "Brother-in-law", "Husband's younger brother");
addPerson("xiaoyi", "小姨", "xiǎoyí", "姨仔", "ji1 zi2", "Sister-in-law", "Wife's younger sister");
addPerson("xifu", "媳妇", "xífù", "新抱", "san1 pou5", "Daughter-in-law", "Son's wife");
addPerson("yeye", "爷爷", "yéyé", "爺爺", "je4 je2", "Grandpa", "Paternal grandfather");
addPerson("yima", "姨妈", "yímā", "姨媽", "ji4 maa1", "Aunt", "Mother's older sister");
addPerson("yisheng", "姨甥", "yíshēng", "外甥", "ngoi6 sang1", "Nephew", "Sister's son (female)");
addPerson("yishengnu", "姨甥女", "yíshēngnǚ", "外甥女", "ngoi6 sang1 neoi5", "Niece", "Sister's daughter (female)");
addPerson("yizhang", "姨丈", "yízhàng", "姨丈", "ji4 zoeng6", "Uncle-in-law", "Mother's sister's husband");
addPerson("yuefu", "岳父", "yuèfù", "外父", "ngoi6 fu2", "Father-in-law", "Wife's father");
addPerson("yuemu", "岳母", "yuèmǔ", "外母", "ngoi6 mou2", "", "Mother-in-law", "Wife's mother");
addPerson("zengsunnu", "曾孙女", "zēngsūnnǚ", "曾孫女", "zang1 syun1 neoi5", "Great-granddaughter", "Son's son's daughter");
addPerson("zengsunzi", "曾孙子", "zēngsūnzi", "息孫", "sik1 syun1", "Great-grandson", "Son's son's son");
addPerson("zengwaisunnu", "曾外孙女", "zēngwàisūnnǚ", "曾外孫女", "zang1 ngoi6 syun1 neoi5", "Great-granddaughter", "Son's daughter's daughter");
addPerson("zengwaisunzi", "曾外孙子", "zēngwàisūnzi", "曾外孫子", "zang1 ngoi6 syun1 zi2", "Great-grandson", "Son's daughter's son");
addPerson("zhinu", "姪女 ", "zhínǚ", "姪女 ", "zat6 neoi5", "Niece", "Brother's daughter");
addPerson("zhizi", "姪子", "zhízi", "姪子", "zat6 zi2", "Nephew", "Brother's son");

addRelationship("ayi", "ba", "waigong");
addRelationship("ayi", "di", "jiujiu");
addRelationship("ayi", "er-older", "biaoge");
addRelationship("ayi", "er-younger", "biaodi");
addRelationship("ayi", "fu", "yizhang");
addRelationship("ayi", "ge", "jiujiu");
addRelationship("ayi", "ma", "waipo");
addRelationship("ayi", "nu-older", "biaojie");
addRelationship("ayi", "nu-younger", "biaomei");

addRelationship("baba", "ba", "yeye");
addRelationship("baba", "di", "shushu");
addRelationship("baba", "ge", "bofu");
addRelationship("baba", "jie", "guma");
addRelationship("baba", "ma", "nainai");
addRelationship("baba", "mei", "gugu");
addRelationship("baba", "qi", "mama");

addRelationship("biaozhinu", "di", "biaozhizi");
addRelationship("biaozhinu", "ge", "biaozhizi");
addRelationship("biaozhinu", "jie", "biaozhinu");
addRelationship("biaozhinu", "ma", "gubiaosao");
addRelationship("biaozhinu", "mei", "biaozhinu");

addRelationship("biaozhizi", "di", "biaozhizi");
addRelationship("biaozhizi", "ge", "biaozhizi");
addRelationship("biaozhizi", "jie", "biaozhinu");
addRelationship("biaozhizi", "ma", "gubiaosao");
addRelationship("biaozhizi", "mei", "biaozhinu");

addRelationship("bofu", "ba", "yeye");
addRelationship("bofu", "er-older", "tangxiong");
addRelationship("bofu", "er-younger", "tangdi");
addRelationship("bofu", "ge", "bofu");
addRelationship("bofu", "jie", "guma");
addRelationship("bofu", "ma", "nainai");
addRelationship("bofu", "nu-older", "tangjie");
addRelationship("bofu", "nu-younger", "tangmei");
addRelationship("bofu", "qi", "boniang");

addRelationship("boniang", "er-older", "tangxiong");
addRelationship("boniang", "er-younger", "tangdi");
addRelationship("boniang", "fu", "bofu");
addRelationship("boniang", "nu-older", "tangjie");
addRelationship("boniang", "nu-younger", "tangmei");

addRelationship("chongwaisunnu", "ba", "waisunnuxu");
addRelationship("chongwaisunnu", "di", "chongwaisunzi");
addRelationship("chongwaisunnu", "ge", "chongwaisunzi");
addRelationship("chongwaisunnu", "jie", "chongwaisunnu");
addRelationship("chongwaisunnu", "ma", "waisunnu");
addRelationship("chongwaisunnu", "mei", "chongwaisunnu");

addRelationship("chongwaisunzi", "ba", "waisunnuxu");
addRelationship("chongwaisunzi", "di", "chongwaisunzi");
addRelationship("chongwaisunzi", "ge", "chongwaisunzi");
addRelationship("chongwaisunzi", "jie", "chongwaisunnu");
addRelationship("chongwaisunzi", "ma", "waisunnu");
addRelationship("chongwaisunzi", "mei", "chongwaisunnu");

addRelationship("dabo", "ba", "gonggong");
addRelationship("dabo", "ge", "dabo");
addRelationship("dabo", "jie", "dagu");
addRelationship("dabo", "ma", "popo");

addRelationship("dagu", "ba", "gonggong");
addRelationship("dagu", "ge", "dabo");
addRelationship("dagu", "jie", "dagu");
addRelationship("dagu", "ma", "popo");

addRelationship("dajiu", "ba", "yuefu");
addRelationship("dajiu", "ma", "yuemu");
addRelationship("dajiu", "ge", "dajiu");
addRelationship("dajiu", "jie", "dayi");

addRelationship("dayi", "ba", "yuefu");
addRelationship("dayi", "ma", "yuemu");
addRelationship("dayi", "ge", "dajiu");
addRelationship("dayi", "jie", "dayi");

addRelationship("didi", "ba", "baba");
addRelationship("didi", "di", "didi");
addRelationship("didi", "er", "zhizi");
addRelationship("didi", "ma", "mama");
addRelationship("didi", "mei", "meimei");
addRelationship("didi", "nu", "zhinu");
addRelationship("didi", "qi", "difu");

addRelationship("difu", "er", "zhizi");
addRelationship("difu", "fu", "didi");
addRelationship("difu", "nu", "zhinu");

addRelationship("erzi", "ba-female", "laogong");
addRelationship("erzi", "ba-male", "wo");
addRelationship("erzi", "di", "erzi");
addRelationship("erzi", "er", "sunzi");
addRelationship("erzi", "ge", "erzi");
addRelationship("erzi", "jie", "nuer");
addRelationship("erzi", "ma-female", "wo");
addRelationship("erzi", "ma-male", "laopo");
addRelationship("erzi", "mei", "nuer");
addRelationship("erzi", "nu", "sunnu");
addRelationship("erzi", "qi", "xifu");

addRelationship("gege", "ba", "baba");
addRelationship("gege", "er", "zhizi");
addRelationship("gege", "ge", "gege");
addRelationship("gege", "jie", "jiejie");
addRelationship("gege", "ma", "mama");
addRelationship("gege", "nu", "zhinu");
addRelationship("gege", "qi", "saozi");

addRelationship("gonggong", "qi", "popo");

addRelationship("gubiaodi", "er", "biaozhizi");
addRelationship("gubiaodi", "nu", "biaozhinu");
addRelationship("gubiaodi", "qi", "gubiaosao");

addRelationship("gubiaoge", "er", "biaozhizi");
addRelationship("gubiaoge", "nu", "biaozhinu");
addRelationship("gubiaoge", "qi", "gubiaosao");

addRelationship("gubiaosao", "er", "biaozhizi");
addRelationship("gubiaosao", "nu", "biaozhinu");

addRelationship("gugu", "ba", "yeye");
addRelationship("gugu", "di", "shushu");
addRelationship("gugu", "er-older", "gubiaoge");
addRelationship("gugu", "er-younger", "gubiaodi");
addRelationship("gugu", "fu", "guzhang");
addRelationship("gugu", "ma", "nainai");
addRelationship("gugu", "mei", "gugu");
addRelationship("gugu", "nu-older", "gubiaojie");
addRelationship("gugu", "nu-younger", "gubiaomei");

addRelationship("guma", "ba", "yeye");
addRelationship("guma", "er-older", "gubiaoge");
addRelationship("guma", "er-younger", "gubiaodi");
addRelationship("guma", "fu", "guzhang");
addRelationship("guma", "ge", "bofu");
addRelationship("guma", "jie", "guma");
addRelationship("guma", "ma", "nainai");
addRelationship("guma", "nu-older", "gubiaojie");
addRelationship("guma", "nu-younger", "gubiaomei");

addRelationship("guzhang", "er-older", "gubiaoge");
addRelationship("guzhang", "er-younger", "gubiaodi");
addRelationship("guzhang", "nu-older", "gubiaojie");
addRelationship("guzhang", "nu-younger", "gubiaomei");

addRelationship("jiejie", "ba", "baba");
addRelationship("jiejie", "er-female", "yisheng");
addRelationship("jiejie", "er-male", "waisheng");
addRelationship("jiejie", "fu", "jiefu");
addRelationship("jiejie", "ge", "gege");
addRelationship("jiejie", "jie", "jiejie");
addRelationship("jiejie", "ma", "mama");
addRelationship("jiejie", "nu-female", "yishengnu");
addRelationship("jiejie", "nu-male", "waishengnu");

addRelationship("jiefu", "er-female", "yisheng");
addRelationship("jiefu", "er-male", "waisheng");
addRelationship("jiefu", "nu-female", "yishengnu");
addRelationship("jiefu", "nu-male", "waishengnu");
addRelationship("jiefu", "qi", "jiejie");

addRelationship("jiujiu", "ba", "waigong");
addRelationship("jiujiu", "di", "jiujiu");
addRelationship("jiujiu", "er-older", "biaoge");
addRelationship("jiujiu", "er-younger", "biaodi");
addRelationship("jiujiu", "ge", "jiujiu");
addRelationship("jiujiu", "ma", "waipo");
addRelationship("jiujiu", "nu-older", "biaojie");
addRelationship("jiujiu", "nu-younger", "biaomei");
addRelationship("jiujiu", "qi", "jiuma");

addRelationship("jiuma", "er-older", "biaoge");
addRelationship("jiuma", "er-younger", "biaodi");
addRelationship("jiuma", "fu", "jiujiu");
addRelationship("jiuma", "nu-older", "biaojie");
addRelationship("jiuma", "nu-younger", "biaomei");

addRelationship("laogong", "ba", "gonggong");
addRelationship("laogong", "di", "xiaoshu");
addRelationship("laogong", "er", "erzi");
addRelationship("laogong", "ge", "dabo");
addRelationship("laogong", "jie", "dagu");
addRelationship("laogong", "ma", "popo");
addRelationship("laogong", "mei", "xiaogu");
addRelationship("laogong", "nu", "nuer");
addRelationship("laogong", "qi", "wo");

addRelationship("laopo", "ba", "yuefu");
addRelationship("laopo", "di", "xiaojiu");
addRelationship("laopo", "er", "erzi");
addRelationship("laopo", "fu", "wo");
addRelationship("laopo", "ge", "dajiu");
addRelationship("laopo", "jie", "dayi");
addRelationship("laopo", "ma", "yuemu");
addRelationship("laopo", "mei", "xiaoyi");
addRelationship("laopo", "nu", "nuer");

addRelationship("mama", "ba", "waigong");
addRelationship("mama", "di", "jiujiu");
addRelationship("mama", "fu", "baba");
addRelationship("mama", "ge", "jiujiu");
addRelationship("mama", "jie", "yima");
addRelationship("mama", "ma", "waipo");
addRelationship("mama", "mei", "ayi");

addRelationship("meifu", "er-female", "yisheng");
addRelationship("meifu", "er-male", "waisheng");
addRelationship("meifu", "qi", "meimei");
addRelationship("meifu", "nu-female", "yishengnu");
addRelationship("meifu", "nu-male", "waishengnu");

addRelationship("meimei", "ba", "baba");
addRelationship("meimei", "di", "didi");
addRelationship("meimei", "er-female", "yisheng");
addRelationship("meimei", "er-male", "waisheng");
addRelationship("meimei", "fu", "meifu");
addRelationship("meimei", "ma", "mama");
addRelationship("meimei", "mei", "meimei");
addRelationship("meimei", "nu-female", "yishengnu");
addRelationship("meimei", "nu-male", "waishengnu");

addRelationship("nainai", "fu", "yeye");

addRelationship("nuer", "ba-female", "laogong");
addRelationship("nuer", "ba-male", "wo");
addRelationship("nuer", "di", "erzi");
addRelationship("nuer", "er", "waisunzi");
addRelationship("nuer", "fu", "nuxu");
addRelationship("nuer", "ge", "erzi");
addRelationship("nuer", "jie", "nuer");
addRelationship("nuer", "ma-female", "wo");
addRelationship("nuer", "ma-male", "laopo");
addRelationship("nuer", "mei", "nuer");
addRelationship("nuer", "nu", "waisunnu");

addRelationship("nuxu", "er", "waisunzi");
addRelationship("nuxu", "nu", "waisunnu");
addRelationship("nuxu", "qi", "nuer");

addRelationship("popo", "fu", "gonggong");

addRelationship("saozi", "er", "zhizi");
addRelationship("saozi", "fu", "gege");
addRelationship("saozi", "nu", "zhinu");

addRelationship("shenshen", "er-older", "tangxiong");
addRelationship("shenshen", "er-younger", "tangdi");
addRelationship("shenshen", "fu", "shushu");
addRelationship("shenshen", "nu-older", "tangjie");
addRelationship("shenshen", "nu-younger", "tangmei");

addRelationship("shushu", "ba", "yeye");
addRelationship("shushu", "di", "shushu");
addRelationship("shushu", "er-older", "tangxiong");
addRelationship("shushu", "er-younger", "tangdi");
addRelationship("shushu", "ma", "nainai");
addRelationship("shushu", "mei", "gugu");
addRelationship("shushu", "nu-older", "tangjie");
addRelationship("shushu", "nu-younger", "tangmei");
addRelationship("shushu", "qi", "shenshen");

addRelationship("sunnu", "ba", "erzi");
addRelationship("sunnu", "di", "sunzi");
addRelationship("sunnu", "er", "zengwaisunzi");
addRelationship("sunnu", "fu", "sunnuxu");
addRelationship("sunnu", "ge", "sunzi");
addRelationship("sunnu", "jie", "sunnu");
addRelationship("sunnu", "ma", "xifu");
addRelationship("sunnu", "mei", "sunnu");
addRelationship("sunnu", "nu", "zengwaisunnu");

addRelationship("sunnuxu", "er", "zengwaisunzi");
addRelationship("sunnuxu", "nu", "zengwaisunnu");
addRelationship("sunnuxu", "qi", "sunnu");

addRelationship("sunxifu", "er", "zengsunzi");
addRelationship("sunxifu", "fu", "sunzi");
addRelationship("sunxifu", "nu", "zengsunnu");

addRelationship("sunzi", "ba", "erzi");
addRelationship("sunzi", "di", "sunzi");
addRelationship("sunzi", "er", "zengsunzi");
addRelationship("sunzi", "ge", "sunzi");
addRelationship("sunzi", "jie", "sunnu");
addRelationship("sunzi", "ma", "xifu");
addRelationship("sunzi", "mei", "sunnu");
addRelationship("sunzi", "nu", "zengsunnu");
addRelationship("sunzi", "qi", "sunxifu");

addRelationship("taigong", "qi", "taipo");

addRelationship("taima", "fu", "taiye");

addRelationship("taipo", "fu", "taigong");

addRelationship("taiye", "qi", "taima");

addRelationship("tangdi", "er", "tangzhizi");
addRelationship("tangdi", "nu", "tangzhinu");
addRelationship("tangdi", "qi", "tangsao");

addRelationship("tangsao", "er", "tangzhizi");
addRelationship("tangsao", "nu", "tangzhinu");

addRelationship("tangxiong", "er", "tangzhizi");
addRelationship("tangxiong", "nu", "tangzhinu");
addRelationship("tangxiong", "qi", "tangsao");

addRelationship("tangzhinu", "di", "tangzhizi");
addRelationship("tangzhinu", "ge", "tangzhizi");
addRelationship("tangzhinu", "jie", "tangzhinu");
addRelationship("tangzhinu", "ma", "tangsao");
addRelationship("tangzhinu", "mei", "tangzhinu");

addRelationship("tangzhizi", "di", "tangzhizi");
addRelationship("tangzhizi", "ge", "tangzhizi");
addRelationship("tangzhizi", "jie", "tangzhinu");
addRelationship("tangzhizi", "ma", "tangsao");
addRelationship("tangzhizi", "mei", "tangzhinu");

addRelationship("waigong", "ba", "taigong");
addRelationship("waigong", "er", "jiujiu");
addRelationship("waigong", "ma", "taipo");
addRelationship("waigong", "qi", "waipo");

addRelationship("waipo", "er", "jiujiu");
addRelationship("waipo", "fu", "waigong");

addRelationship("waisheng", "di", "waisheng");
addRelationship("waisheng", "ge", "waisheng");
addRelationship("waisheng", "jie", "waishengnu");
addRelationship("waisheng", "mei", "waishengnu");

addRelationship("waishengnu", "di", "waisheng");
addRelationship("waishengnu", "ge", "waisheng");
addRelationship("waishengnu", "jie", "waishengnu");
addRelationship("waishengnu", "mei", "waishengnu");

addRelationship("waisunnu", "ba", "nuxu");
addRelationship("waisunnu", "di", "waisunzi");
addRelationship("waisunnu", "er", "chongwaisunzi");
addRelationship("waisunnu", "fu", "waisunnuxu");
addRelationship("waisunnu", "ge", "waisunzi");
addRelationship("waisunnu", "jie", "waisunnu");
addRelationship("waisunnu", "ma", "nuer");
addRelationship("waisunnu", "mei", "waisunnu");
addRelationship("waisunnu", "nu", "chongwaisunnu");

addRelationship("waisunnuxu", "er", "chongwaisunzi");
addRelationship("waisunnuxu", "nu", "chongwaisunnu");
addRelationship("waisunnuxu", "qi", "waisunnu");

addRelationship("waisunxifu", "er", "waizengsunzi");
addRelationship("waisunxifu", "fu", "waisunzi");
addRelationship("waisunxifu", "nu", "waizengsunnu");

addRelationship("waisunzi", "ba", "nuxu");
addRelationship("waisunzi", "di", "waisunzi");
addRelationship("waisunzi", "er", "waizengsunzi");
addRelationship("waisunzi", "ge", "waisunzi");
addRelationship("waisunzi", "jie", "waisunnu");
addRelationship("waisunzi", "ma", "nuer");
addRelationship("waisunzi", "mei", "waisunnu");
addRelationship("waisunzi", "nu", "waizengsunnu");
addRelationship("waisunzi", "qi", "waisunxifu");

addRelationship("waizengsunnu", "ba", "waisunzi");
addRelationship("waizengsunnu", "di", "waizengsunzi");
addRelationship("waizengsunnu", "ge", "waizengsunzi");
addRelationship("waizengsunnu", "jie", "waizengsunnu");
addRelationship("waizengsunnu", "ma", "waisunxifu");
addRelationship("waizengsunnu", "mei", "waizengsunnu");

addRelationship("waizengsunzi", "ba", "waisunzi");
addRelationship("waizengsunzi", "di", "waizengsunzi");
addRelationship("waizengsunzi", "ge", "waizengsunzi");
addRelationship("waizengsunzi", "jie", "waizengsunnu");
addRelationship("waizengsunzi", "ma", "waisunxifu");
addRelationship("waizengsunzi", "mei", "waizengsunnu");

addRelationship("wo", "ba", "baba");
addRelationship("wo", "di", "didi");
addRelationship("wo", "er", "erzi");
addRelationship("wo", "fu", "laogong");
addRelationship("wo", "ge", "gege");
addRelationship("wo", "jie", "jiejie");
addRelationship("wo", "ma", "mama");
addRelationship("wo", "mei", "meimei");
addRelationship("wo", "nu", "nuer");
addRelationship("wo", "qi", "laopo");

addRelationship("xiaogu", "ba", "gonggong");
addRelationship("xiaogu", "di", "xiaoshu");
addRelationship("xiaogu", "ma", "popo");
addRelationship("xiaogu", "mei", "xiaogu");

addRelationship("xiaojiu", "ba", "yuefu");
addRelationship("xiaojiu", "ma", "yuemu");
addRelationship("xiaojiu", "di", "xiaojiu");
addRelationship("xiaojiu", "mei", "xiaoyi");

addRelationship("xiaoshu", "ba", "gonggong");
addRelationship("xiaoshu", "di", "xiaoshu");
addRelationship("xiaoshu", "ma", "popo");
addRelationship("xiaoshu", "mei", "xiaogu");

addRelationship("xiaoyi", "ba", "yuefu");
addRelationship("xiaoyi", "ma", "yuemu");
addRelationship("xiaoyi", "di", "xiaojiu");
addRelationship("xiaoyi", "mei", "xiaoyi");

addRelationship("xifu", "er", "sunzi");
addRelationship("xifu", "fu", "erzi");
addRelationship("xifu", "nu", "sunnu");

addRelationship("yeye", "ba", "taiye");
addRelationship("yeye", "ma", "taima");
addRelationship("yeye", "qi", "nainai");

addRelationship("yima", "ba", "waigong");
addRelationship("yima", "di", "jiujiu");
addRelationship("yima", "er-older", "biaoge");
addRelationship("yima", "er-younger", "biaodi");
addRelationship("yima", "fu", "yizhang");
addRelationship("yima", "ge", "jiujiu");
addRelationship("yima", "ma", "waipo");
addRelationship("yima", "nu-older", "biaojie");
addRelationship("yima", "nu-younger", "biaomei");

addRelationship("yisheng", "di", "yisheng");
addRelationship("yisheng", "ge", "yisheng");
addRelationship("yisheng", "jie", "yishengnu");
addRelationship("yisheng", "mei", "yishengnu");

addRelationship("yishengnu", "di", "yisheng");
addRelationship("yishengnu", "ge", "yisheng");
addRelationship("yishengnu", "jie", "yishengnu");
addRelationship("yishengnu", "mei", "yishengnu");

addRelationship("yizhang", "er-older", "biaoge");
addRelationship("yizhang", "er-younger", "biaodi");
addRelationship("yizhang", "nu-older", "biaojie");
addRelationship("yizhang", "nu-younger", "biaomei");

addRelationship("zengsunnu", "ba", "sunzi");
addRelationship("zengsunnu", "di", "zengsunzi");
addRelationship("zengsunnu", "ge", "zengsunzi");
addRelationship("zengsunnu", "jie", "zengsunnu");
addRelationship("zengsunnu", "ma", "sunxifu");
addRelationship("zengsunnu", "mei", "zengsunnu");

addRelationship("zengsunzi", "ba", "sunzi");
addRelationship("zengsunzi", "di", "zengsunzi");
addRelationship("zengsunzi", "ge", "zengsunzi");
addRelationship("zengsunzi", "jie", "zengsunnu");
addRelationship("zengsunzi", "ma", "sunxifu");
addRelationship("zengsunzi", "mei", "zengsunnu");

addRelationship("zengwaisunnu", "ba", "sunnuxu");
addRelationship("zengwaisunnu", "di", "zengwaisunzi");
addRelationship("zengwaisunnu", "ge", "zengwaisunzi");
addRelationship("zengwaisunnu", "jie", "zengwaisunnu");
addRelationship("zengwaisunnu", "ma", "sunnu");
addRelationship("zengwaisunnu", "mei", "zengwaisunnu");

addRelationship("zengwaisunzi", "ba", "sunnuxu");
addRelationship("zengwaisunzi", "di", "zengwaisunzi");
addRelationship("zengwaisunzi", "ge", "zengwaisunzi");
addRelationship("zengwaisunzi", "jie", "zengwaisunnu");
addRelationship("zengwaisunzi", "ma", "sunnu");
addRelationship("zengwaisunzi", "mei", "zengwaisunnu");

addRelationship("zhizi", "di", "zhizi");
addRelationship("zhizi", "ge", "zhizi");
addRelationship("zhizi", "jie", "zhinu");
addRelationship("zhizi", "mei", "zhinu");

addRelationship("zhinu", "di", "zhizi");
addRelationship("zhinu", "ge", "zhizi");
addRelationship("zhinu", "jie", "zhinu");
addRelationship("zhinu", "mei", "zhinu");

var relationships = [];

relationships["ba"] = {
	en: "Father",
	cn: "爸爸",
	pinyin: "bàba",
};
relationships["ba-female"] = {
	en: "Father",
	cn: "爸爸（我是女）",
	pinyin: "bàba",
};
relationships["ba-male"] = {
	en: "Father",
	cn: "爸爸（我是男）",
	pinyin: "bàba",
};
relationships["di"] = {
	en: "Younger brother",
	cn: "弟弟",
	pinyin: "dìdì",
};
relationships["er"] = {
	en: "Son",
	cn: "儿子",
	pinyin: "érzi",
};
relationships["er-female"] = {
	en: "Son",
	cn: "儿子（我是女）",
	pinyin: "érzi",
};
relationships["er-male"] = {
	en: "Son",
	cn: "儿子（我是男）",
	pinyin: "érzi",
};
relationships["er-older"] = {
	en: "Son",
	cn: "儿子（比我大）",
	pinyin: "érzi",
};
relationships["er-younger"] = {
	en: "Son",
	cn: "儿子（比我小）",
	pinyin: "érzi",
};
relationships["fu"] = {
	en: "Husband",
	cn: "丈夫",
	pinyin: "zhàngfū",
};
relationships["ge"] = {
	en: "Older brother",
	cn: "哥哥",
	pinyin: "gēgē",
};
relationships["jie"] = {
	en: "Older sister",
	cn: "姐姐",
	pinyin: "jiějiě",
};
relationships["ma"] = {
	en: "Mother",
	cn: "妈妈",
	pinyin: "māmā",
};
relationships["ma-female"] = {
	en: "Mother",
	cn: "妈妈（我是女）",
	pinyin: "māmā",
};
relationships["ma-male"] = {
	en: "Mother",
	cn: "妈妈（我是男）",
	pinyin: "māmā",
};
relationships["mei"] = {
	en: "Younger sister",
	cn: "妹妹",
	pinyin: "mèimei",
};
relationships["nu"] = {
	en: "Daughter",
	cn: "女儿",
	pinyin: "nǚ",
};
relationships["nu-female"] = {
	en: "Daughter",
	cn: "女儿（我是女）",
	pinyin: "nǚér",
};
relationships["nu-male"] = {
	en: "Daughter (male)",
	cn: "女儿（我是男）",
	pinyin: "nǚér",
};
relationships["nu-older"] = {
	en: "Daughter",
	cn: "女儿（比我大）",
	pinyin: "nǚér",
};
relationships["nu-younger"] = {
	en: "Daughter",
	cn: "女儿（比我小）",
	pinyin: "nǚér",
};
relationships["qi"] = {
	en: "Wife",
	cn: "妻子",
	pinyin: "qīzi",
};
relationships["qi"] = {
	en: "Wife",
	cn: "妻子",
	pinyin: "qīzi",
};

// Data mostly based on Off the Great Wall's Chinese Family Tree
// https://www.youtube.com/watch?v=nCFRoILS1jY
// https://www.youtube.com/watch?v=A1HaZ4WLo50