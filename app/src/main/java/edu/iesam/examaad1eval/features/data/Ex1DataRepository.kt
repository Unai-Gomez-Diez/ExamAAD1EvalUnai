package edu.iesam.examaad1eval.features.data

import edu.iesam.examaad1eval.features.data.local.ItemXmlLocalDataSource
import edu.iesam.examaad1eval.features.data.local.ServicesXmlLocalDataSource
import edu.iesam.examaad1eval.features.data.local.UserXmlLocalDataSource
import edu.iesam.examaad1eval.features.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User

class Ex1DataRepository(
    private val userXmlLocalDataSource: UserXmlLocalDataSource,
    private val mockEx1RemoteDataSource: MockEx1RemoteDataSource,
    private val itemXmlLocalDataSource: ItemXmlLocalDataSource,
    private val servicesXmlLocalDataSource: ServicesXmlLocalDataSource
): Ex1Repository {
    override fun getUsers(): List<User> {
        val users = userXmlLocalDataSource.getUsers()
        if (users.isEmpty()){
            val remote = mockEx1RemoteDataSource.getUsers()
            userXmlLocalDataSource.saveUsers(remote)
            return remote
        } else {
            return users
        }
    }

    override fun getItems(): List<Item> {
        val items = itemXmlLocalDataSource.getItems()
        if (items.isEmpty()){
            val remote = mockEx1RemoteDataSource.getItems()
            itemXmlLocalDataSource.saveItems(remote)
            return remote
        } else {
            return items
        }
    }

    override fun getServices(): List<Services> {
        val services = servicesXmlLocalDataSource.getServices()
        if (services.isEmpty()){
            val remote = mockEx1RemoteDataSource.getServices()
            servicesXmlLocalDataSource.saveServices(remote)
            return remote
        } else {
            return services
        }
    }

}