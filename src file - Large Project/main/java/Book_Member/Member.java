package Book_Member;

public class Member {
        private String name;
        private Long personal_number;
        int level;          // 1 = undergrad, 2 = master, 3 = phd, 4 = staff

        public Member(String name, Long p_number, int lvl) {
            this.name = name;
            this.personal_number = p_number;
            this.level = lvl;
        }

        public String getName() {
            return name;
        }

        public Long getPersonal_number(){ return personal_number; }

        public int getLevel() {
            return level;
        }

    }
    
