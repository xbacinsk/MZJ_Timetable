declare variable $inputDocument external;

let $doc := doc($inputDocument)

for $day in $doc//den
  let $dayName := $day/@id
  return
  for $slot in $day//slot
  let $timeFrom := $slot/@odcas
  let $timeTo := $slot/@docas
  let $rooms :=
    string-join((for $room in $slot//mistnosti/mistnost
      let $roomName := data($room//mistnostozn)
      let $roomId := data($room//mistnostid)
      
      return string-join(($roomId,$roomName),"#")),"#")
  let $courseCode := data($slot//kod)
  let $courseName := data($slot//nazev)
  let $courseId := data($slot//predmetid)
  let $teachers :=
    string-join((for $teacher in $slot//ucitele/ucitel
      let $teacherId := data($teacher/ucitelid)
      let $teacherName := data($teacher/uciteljmeno)
      
      return string-join(($teacherId,$teacherName),"#")),"#")
  
  return string-join(($dayName,$timeFrom,$timeTo,$rooms,$courseCode,$courseName,$courseId,$teachers),";")