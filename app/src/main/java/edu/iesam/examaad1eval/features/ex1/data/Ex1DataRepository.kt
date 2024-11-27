package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User
import edu.iesam.examaad1eval.features.ex1.data.local.ItemXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.local.ServicesXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.local.UserXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource

class Ex1DataRepository(
    private val userXmlLocalDataSource: UserXmlLocalDataSource,
    private val mockEx1RemoteDataSource: MockEx1RemoteDataSource,
    private val itemXmlLocalDataSource: ItemXmlLocalDataSource,
    private val servicesXmlLocalDataSource: ServicesXmlLocalDataSource
): Ex1Repository {
    override fun getUsers(): List<User> {
        val users = userXmlLocalDataSource.getUsers()
        return if (users == null) {
            val remote = mockEx1RemoteDataSource.getUsers()
            userXmlLocalDataSource.saveUsers(remote)
            remote
        } else {
            users
        }
    }

    override fun getItems(): List<Item> {
        val items = itemXmlLocalDataSource.getItems()
        return if (items == null) {
            val remote = mockEx1RemoteDataSource.getItems()
            itemXmlLocalDataSource.saveItems(remote)
            remote
        } else {
            items
        }
    }

    override fun getServices(): List<Services> {
        val services = servicesXmlLocalDataSource.getServices()
        return if (services == null) {
            val remote = mockEx1RemoteDataSource.getServices()
            servicesXmlLocalDataSource.saveServices(remote)
            remote
        } else {
            services
        }
    }

}