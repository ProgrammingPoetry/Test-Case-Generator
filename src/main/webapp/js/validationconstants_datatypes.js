/*Parameters required in the JSON request are:

category: Should be the string literal "numbers"
testCases: Should lie within the range [0,100000] (both inclusive)
minValue: [-10^9,10^9]
maxValue: [-10^9,10^9] (Additional constraint: minValue <= maxValue)
multipleOf: [1,1000]
distinct: true/false (Note the case)
prime: true/false (Note the case)*/


var number_min_testCases=0;
var number_max_testCases=100000;
var number_min_minValue=-10000;
var number_max_minValue= 10000;
var number_min_maxValue=-10000;
var number_max_maxValue= 10000;
var number_min_multipleOf=1;
var number_max_multipleOf=1000;


/*Parameters required in the JSON request are:

category: Should be the string literal "characters"
testCases: [0,100000]
minValue: [a-z/A-Z]
maxValue: [a-z/A-Z] (Additional constraint: minValue <= maxValue)
case: Can be one of: "lower", "upper", "mixed"
distinct: true/false (Note the case)*/

var character_min_testCases=0;
var character_max_testCases=100000;
var character_min_minValue='a' || 'A';
var character_max_minValue='z' || 'Z';
var character_min_maxValue='a' || 'A';
var character_max_maxValue='z' || 'Z';



/*category: Should be the string literal "strings"
testCases: [0,10000]
minValue: [a-z/A-Z]
maxValue: [a-z/A-Z] (Additional constraint: minValue <= maxValue)
case: Can be one of: "lower", "upper", "mixed"
minStringLength: [1,10^3]
maxStringLength: [1,10^3] (Additional constraint: minStringLength <= maxStringLength)
printLength: true/false
whiteSpaceCharacter: Can be one of "space", "newLine" (Additional constraint, only when printLength is true, whiteSpaceCharacter must be sent in the request. Otherwise send it as an empty string)
isPalindrome: true/false
sorted: true/false*/


var string_min_testCases=0;
var string_max_testCases=100000;
var string_min_minValue='a'||'A';
var string_max_minValue='z'||'Z';
var string_min_maxValue='a'||'A';
var string_max_maxValue='z'||'Z';
var string_min_minStringLength=1;
var string_max_minStringLength=10^3;
var string_min_maxStringLength=1;
var string_max_maxStringLength=10^3;

