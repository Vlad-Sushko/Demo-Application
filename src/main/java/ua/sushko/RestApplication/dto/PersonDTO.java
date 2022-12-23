package ua.sushko.RestApplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class PersonDTO {
        private Long id;

        @NotEmpty
        @Size(min = 2, max = 45, message = "Name must contain 2-45 characters")
        private String name;

        @NotEmpty
        @Size(min = 2, max = 45, message = "Surname must contain 2-45 characters")
        private String surname;

        private int age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


}

