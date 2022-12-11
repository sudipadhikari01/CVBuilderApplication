package com.sudip.cvapp.data

data class Education(
    val collegeName: String,
    val program: String,
    val logo: String
) {

    companion object {
        fun getEducationList() : MutableList<Education> {
            return mutableListOf(
                Education(
                    "Maharishi International University",
                    "Master's in Computer Science",
                    "https://maharishischool.org/wp-content/uploads/MaharishiSchoolTreeLogo-8cc541-green.jpg"
                ),
                Education(
                    "Ambition College",
                    "Bachelor's in Computer Science and Information Technology",
                    "https://www.ambition.edu.np/files/rpefczbyzf27uvzjyh87/logo.png"
                )
            )
        }
    }
}
