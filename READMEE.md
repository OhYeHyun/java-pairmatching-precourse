## 기능 목록
 
- CSVReader
    - 파일 읽어와 List<String> 으로 저장

- Course
    - course, level

- Level
    - level, missions

- Crew
    - course, name 을 갖는 객체

- Group
    - List<Crew>

- CrewByLevelRepository
    - Map<Crew, List<Crew>>

- CrewByCourseRepository
    - List<Crew> 

- MatchingGenerator
    - 랜덤 List<Crew> 생성

- GenerateService
    - 2명씩 Group 으로 생성하여 List<Group>
    - 만난 적 있는 크루가 존재하면 다시 생성
    - 3회 이상 실패 시 오류 발생

- RepositoryService
    - LevelRepository 업데이트

- PairMatching
    - 매칭 전체 로직 

