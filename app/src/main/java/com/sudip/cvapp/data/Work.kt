package com.sudip.cvapp.data

data class Work(
    val companyName: String,
    val fromDate: String,
    val toDate: String,
    val location: String,
    val logo: String,
    val roles: String
) {
    companion object {
        fun getWorkList() : MutableList<Work> {
            return mutableListOf(
                Work(
                    "Try Catch IT Services Nepal",
                    "July 2021",
                    "December 2021",
                    "Kathmandu, Nepal",
                    "https://trycatch.com.np/Try_Catch_Logo.png",
                    "worked on CRM and developed Enterprise Application"
                ),
                Work(
                    "Crupee Software Development Pvt. Ltd",
                    "Jan 2019",
                    "June 2021",
                    "Kathmandu, Nepal",
                    "https://crupeesoft.com/crupeeSoftware.png",
                    "Worked on various web-related projects, testing, and project management as a Java developer."
                ),
                Work(
                    "Mandala System Pvt. Ltd",
                    "Jan 2018",
                    "December 2018",
                    "Kathmandu, Nepal",
                    "https://crupeesoft.com/crupeeSoftware.png",
                    "I worked as a junior developer and developed a software system for a stockbroker"
                ),
            )
        }
    }
}
